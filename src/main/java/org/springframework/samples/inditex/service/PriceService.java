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

    @Transactional
    public List<Price> getAll() {
        return priceRepository.findAll();
    }

    @Transactional
    public List<Price> getPriceByDateAndProductAndBrand(LocalDateTime date, int productId, int brandId) {
        return priceRepository.findFirstBetweenDateAndProductIdAndBrandId(
                date, productId, brandId);
    }

    @Transactional
    public Price save(Price price) {
        return priceRepository.save(price);
    }

}
