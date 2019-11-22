package com.george.store.controllers;

import com.george.store.database.entities.ProductEntity;
import com.george.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> findALl(){
        return productService.findAll();
    }

    @PostMapping
    public void createProduct(@RequestBody ProductEntity productEntity){
        productService.createProduct(productEntity);
    }

}
