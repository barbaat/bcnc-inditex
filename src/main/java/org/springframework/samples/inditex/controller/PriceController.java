package org.springframework.samples.inditex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.inditex.model.Price;
import org.springframework.samples.inditex.service.PriceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    /**
     * Endpoint to retrieve all prices.
     *
     * @param request HttpServletRequest object for handling HTTP-specific features
     * @return ResponseEntity with a list of Price objects and HTTP status OK if successful,
     *         HttpStatus.NOT_FOUND if an exception occurs
     */
    @RequestMapping(value = "/get-all")
    public ResponseEntity<?> getAll(HttpServletRequest request) {
        try {
            List<Price> prices = priceService.getAll();
            return new ResponseEntity<>(prices, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exception and return NOT_FOUND status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint to retrieve the price for a given date, product, and brand.
     *
     * @param date      LocalDateTime representing the date for price retrieval
     * @param productId ID of the product
     * @param brandId   ID of the brand
     * @return ResponseEntity with the retrieved Price object and HTTP status OK if successful,
     *         HttpStatus.NOT_FOUND if no price is found
     */
    @RequestMapping(value = "/get-price")
    public ResponseEntity<?> getPrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam int productId, @RequestParam int brandId) {
        List<Price> prices = priceService.getPriceByDateAndProductAndBrand(date, productId, brandId);

        if (prices.isEmpty()) {
            // Return NOT_FOUND status if no price is found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // Return the first Price object found and OK status
            return new ResponseEntity<>(prices.get(0), HttpStatus.OK);
        }
    }
}
