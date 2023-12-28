package org.springframework.samples.inditex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "price")
@Getter
@Setter
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int brand_id;

    @NotNull
    private LocalDateTime start_dat;

    @NotNull
    private LocalDateTime end_dat;

    @NotNull
    private int price_list;

    @NotNull
    private int product_id;

    @NotNull
    @JsonIgnore
    private Integer priority;

    @NotNull
    private Double price;

    @NotNull
    private String currency;

    @ManyToOne
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    @JsonIgnore
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonIgnore
    private Product product;
    
    public String getBrandName() {
        return brand.getName();
    }

    public String getProductName() {
        return product.getName();
    }
    
    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", productId=" + getProductName() +
                ", brand=" + getBrandName() +
                ", priceList=" + price_list +
                ", startDate=" + start_dat +
                ", endDate=" + end_dat +
                ", price=" + price +
                '}';
    }

}
