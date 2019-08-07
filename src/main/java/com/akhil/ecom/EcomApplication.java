package com.akhil.ecom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.akhil.ecom.model.Product;
import com.akhil.ecom.service.ProductService;
/**
 * 
 * @author akhil
 *
 */
@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}
	
	@Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Jeans", 300.00, "Levis", "jeans.jpg"));
            productService.save(new Product(2L, "Tops", 200.00, "Prada", "tops.jpg"));
            productService.save(new Product(3L, "Sweater", 100.00, "US Polo", "sweater.jpg"));
            productService.save(new Product(4L, "jacket", 500.00, "Us Polo", "jacket.jpg"));
        };
    }

}
