package org.springframework.samples.inditex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.inditex.model.Price;
import org.springframework.samples.inditex.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    /**
     * Retrieves all prices.
     *
     * @return List of Price objects representing all prices in the repository
     */
    @Transactional
    public List<Price> getAll() {
        return priceRepository.findAll();
    }

    /**
     * Retrieves prices based on the provided date, product ID, and brand ID.
     *
     * @param date      LocalDateTime representing the date for price retrieval
     * @param productId ID of the product
     * @param brandId   ID of the brand
     * @return List of Price objects that match the given criteria
     */
    @Transactional
    public List<Price> getPriceByDateAndProductAndBrand(LocalDateTime date, int productId, int brandId) {
        return priceRepository.findFirstBetweenDateAndProductIdAndBrandId(date, productId, brandId);
    }

    /**
     * Saves a new Price object.
     *
     * @param price The Price object to be saved
     * @return The saved Price object
     */
    @Transactional
    public Price save(Price price) {
        return priceRepository.save(price);
    }
}
