package org.springframework.samples.inditex.controllers;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.samples.inditex.controller.PriceController;
import org.springframework.samples.inditex.model.Brand;
import org.springframework.samples.inditex.model.Price;
import org.springframework.samples.inditex.model.Product;
import org.springframework.samples.inditex.service.BrandService;
import org.springframework.samples.inditex.service.PriceService;
import org.springframework.samples.inditex.service.ProductService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.BDDMockito.given;

@WebMvcTest(PriceController.class)
class PricesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @MockBean
    private ProductService productService;

    @MockBean
    private BrandService brandService;

    private Price price1;
    private Price price2;
    private Price price3;
    private Price price4;

    @BeforeEach
    void setup() {
        // Creating a Brand object and a Product object
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("Zara");
        brand = brandService.createBrand(brand);

        Product product = new Product();
        product.setId(35455);
        product.setName("Shirt");
        product = productService.createProduct(product);

        // Creating Price objects using the createPrice method
        price1 = createPrice(1, 35.50, LocalDateTime.of(2020, 04, 14, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59), brand, product);

        price2 = createPrice(2, 25.45, LocalDateTime.of(2020, 6, 14, 15, 0),
                LocalDateTime.of(2020, 6, 14, 18, 30), brand, product);

        price3 = createPrice(3, 30.50, LocalDateTime.of(2020, 6, 15, 0, 0),
                LocalDateTime.of(2020, 6, 15, 11, 0), brand, product);

        price4 = createPrice(4, 38.95, LocalDateTime.of(2020, 6, 15, 16, 0),
                LocalDateTime.of(2020, 6, 15, 23, 59), brand, product);

        // Configuring mock behavior for the PriceService
        given(priceService.getAll()).willReturn(Arrays.asList(price1, price2, price3, price4));
        given(priceService.getPriceByDateAndProductAndBrand(LocalDateTime.of(2020, 8, 1, 12, 0), 35455, 1))
                .willReturn(Arrays.asList(price1));
    }

    private Price createPrice(int id, double price, LocalDateTime startDateTime, LocalDateTime endDateTime,
            Brand brand, Product product) {
        // Utility method for creating Price objects
        Price priceObj = new Price();
        priceObj.setId(id);
        priceObj.setBrand(brand);
        priceObj.setProduct(product);
        priceObj.setStart_dat(startDateTime);
        priceObj.setEnd_dat(endDateTime);
        priceObj.setPrice_list(id);
        priceObj.setPriority(1);
        priceObj.setPrice(price);
        priceObj.setCurrency("EUR");
        return priceObj;
    }

    @Test
    void getPriceValue() throws Exception {
        // Testing GET request to the /price/get-price endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/price/get-price")
                .param("date", "2020-08-01T12:00:00")
                .param("productId", "35455")
                .param("brandId", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }
}
