package com.akhil.ecom.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author akhil
 *
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product title is required.")
    private String title;

    private Double price;
    
    private String brand;

    private String imageUrl;

    public Product(Long id, @NotNull(message = "Product title is required.") String title, Double price, String brand, String imageUrl) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.imageUrl = imageUrl;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}