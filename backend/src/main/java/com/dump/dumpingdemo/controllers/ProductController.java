package com.dump.dumpingdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dump.dumpingdemo.helper.ProductExcelHelper;
import com.dump.dumpingdemo.services.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
        if(ProductExcelHelper.hasExcelFormat(file)){
            productService.saveProduct(file);
            return ResponseEntity.ok("File uploaded successfully");
        }
        return ResponseEntity.ok("Please upload an excel file");
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    
}
