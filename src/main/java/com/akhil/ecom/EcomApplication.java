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
    public CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Jeans", 30.00, "Levis", "https://images-na.ssl-images-amazon.com/images/I/71vdopEovDL._UX679_.jpg", true));
            productService.save(new Product(2L, "Tops", 20.00, "Prada", "https://cdn1.jolicloset.com/imgr/full/2018/07/74155-1/prada-multiple-colors-cotton-tops.jpg", false));
            productService.save(new Product(3L, "Sweater", 10.00, "US Polo", "https://images-na.ssl-images-amazon.com/images/I/A1uxlIAs%2BgL._UX425_.jpg", false));
            productService.save(new Product(4L, "jacket", 50.00, "Us Polo", "https://dtpmhvbsmffsz.cloudfront.net/posts/2016/05/01/572636733c6f9f1e43005d0e/m_572636733c6f9f1e43005d0f.jpg", true));
            productService.save(new Product(5L, "Shirt", 5.00, "UCB", "https://cdn.shopify.com/s/files/1/0605/4293/products/Levis_046a_1110x.progressive.jpg?v=1520865611", true));
            productService.save(new Product(6L, "Trousers", 25.00, "Hollister", "https://images.prod.meredith.com/product/d28a09259700dbbcd9b82d531f76ecd5/1532843900251/l/hollister-side-tape-logo-track-pants-in-navy-navy", false));
            productService.save(new Product(7L, "wallet", 50.00, "armani", "https://images-na.ssl-images-amazon.com/images/I/71l2BVL0FVL._UX679_.jpg", false));
            productService.save(new Product(8L, "shoes", 50.00, "gucci", "https://di2ponv0v5otw.cloudfront.net/posts/2018/02/23/5a901fed84b5ce0ee86ba67f/m_5a90202236b9de751c53f4b4.jpg", true));
        };
    }

}
