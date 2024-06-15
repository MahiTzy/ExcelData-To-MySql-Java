package com.dump.dumpingdemo.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.dump.dumpingdemo.Entity.Product;

public class ProductExcelHelper {

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Product> convertExcelToProducts(InputStream is) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rows = sheet.iterator();
            List<Product> products = new ArrayList<Product>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Product product = new Product();
                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIndex) {
                        case 0:
                            product.setpID((int) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            product.setpDesc(currentCell.getStringCellValue());
                            break;

                        case 2:
                            product.setpName(currentCell.getStringCellValue());
                            break;

                        case 3:
                            product.setpPrice((int) currentCell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIndex++;
                }
                products.add(product);
            }
            workbook.close();
            return products;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
