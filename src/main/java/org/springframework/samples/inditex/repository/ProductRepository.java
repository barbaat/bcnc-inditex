package org.springframework.samples.inditex.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.inditex.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
