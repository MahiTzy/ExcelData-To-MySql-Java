package com.dump.dumpingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dump.dumpingdemo.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}
