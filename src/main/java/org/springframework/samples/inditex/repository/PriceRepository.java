package org.springframework.samples.inditex.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.inditex.model.Price;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer> {

    @Query("SELECT p FROM Price p WHERE p.start_dat <= ?1 AND p.end_dat >= ?1 AND p.product_id = ?2 AND p.brand_id = ?3 ORDER BY p.priority DESC")
    List<Price> findFirstBetweenDateAndProductIdAndBrandId(LocalDateTime date, int productId, int brandId);

    @Query("SELECT p FROM Price p")
    List<Price> findAll();
}
