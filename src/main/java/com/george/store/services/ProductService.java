package com.george.store.services;

import com.george.store.database.entities.ProductEntity;
import com.george.store.database.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public void createProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public ProductEntity findOne(Integer productId) {
        return productRepository.findById(productId).get();
    }
}
