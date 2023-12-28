package org.springframework.samples.inditex.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.inditex.model.Price;
import org.springframework.samples.inditex.repository.PriceRepository;
import org.springframework.samples.inditex.service.PriceService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PricesServicesTests {
    
    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPriceByDatesAndProductAndBrand() {
        // Test method for getPriceByDateAndProductAndBrand in PriceService
        LocalDateTime date = LocalDateTime.now();
        int productId = 1;
        int brandId = 2;
        
        // Create an empty list of prices to be returned by the mock
        List<Price> prices = new ArrayList<>();
        when(priceRepository.findFirstBetweenDateAndProductIdAndBrandId(date, productId, brandId)).thenReturn(prices);

        // Call the method being tested
        List<Price> result = priceService.getPriceByDateAndProductAndBrand(date, productId, brandId);

        // Verify that the result matches the expected list of prices
        assertEquals(prices, result);
        
        // Verify that the repository method was called exactly once with the specified arguments
        verify(priceRepository, times(1)).findFirstBetweenDateAndProductIdAndBrandId(date, productId, brandId);
    }
}
