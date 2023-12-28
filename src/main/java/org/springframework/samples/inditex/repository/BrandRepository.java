package org.springframework.samples.inditex.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.inditex.model.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {

}
