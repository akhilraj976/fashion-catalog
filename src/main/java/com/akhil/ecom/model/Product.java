package com.akhil.ecom.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author akhil
 *
 */
@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product title is required.")
    private String title;

    private Double price;
    
    private String brand;

    private String imageUrl;
    
    @JsonIgnore
    private boolean trending;
    

    public Product(Long id, @NotNull(message = "Product title is required.") String title, Double price, String brand, String imageUrl, boolean trending) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.imageUrl = imageUrl;
        this.trending = trending;
    }

    public Product() {
    }

}