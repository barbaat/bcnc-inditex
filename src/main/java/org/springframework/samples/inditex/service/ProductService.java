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

    /**
     * Creates a new product.
     *
     * @param product The Product object to be created
     * @return The created Product object
     */
    @Transactional
    public Product createProduct(Product product) {
        // Save the product using the injected ProductRepository
        return productRepository.save(product);
    }
}
