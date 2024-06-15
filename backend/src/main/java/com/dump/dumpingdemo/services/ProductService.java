package com.dump.dumpingdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dump.dumpingdemo.Entity.Product;
import com.dump.dumpingdemo.helper.ProductExcelHelper;
import com.dump.dumpingdemo.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void saveProduct(MultipartFile file) {
        try {
            if (ProductExcelHelper.hasExcelFormat(file)) {
                List<Product> products = ProductExcelHelper.convertExcelToProducts(file.getInputStream());
                this.productRepo.saveAll(products);
            }
        } catch (Exception e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }
    
}
