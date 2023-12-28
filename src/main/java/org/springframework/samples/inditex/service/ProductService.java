package org.springframework.samples.inditex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.inditex.model.Product;
import org.springframework.samples.inditex.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
