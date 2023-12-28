package org.springframework.samples.inditex.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.inditex.model.Price;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer> {

    /**
     * Retrieves prices based on the provided date, product ID, and brand ID.
     *
     * @param date      LocalDateTime representing the date for price retrieval
     * @param productId ID of the product
     * @param brandId   ID of the brand
     * @return List of Price objects that match the given criteria, ordered by priority descending
     */
    @Query("SELECT p FROM Price p WHERE p.start_dat <= ?1 AND p.end_dat >= ?1 AND p.product_id = ?2 AND p.brand_id = ?3 ORDER BY p.priority DESC")
    List<Price> findFirstBetweenDateAndProductIdAndBrandId(LocalDateTime date, int productId, int brandId);

    /**
     * Retrieves all prices.
     *
     * @return List of all Price objects in the repository
     */
    @Query("SELECT p FROM Price p")
    List<Price> findAll();
}
