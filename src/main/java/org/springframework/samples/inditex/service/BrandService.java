package org.springframework.samples.inditex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.inditex.model.Brand;
import org.springframework.samples.inditex.repository.BrandRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    /**
     * Creates a new brand.
     *
     * @param brand The Brand object to be created
     * @return The created Brand object
     */
    @Transactional
    public Brand createBrand(Brand brand) {
        // Save the brand using the injected BrandRepository
        return brandRepository.save(brand);
    }
}
