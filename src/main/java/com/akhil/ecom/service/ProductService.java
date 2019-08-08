package com.akhil.ecom.service;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.akhil.ecom.model.Product;
/**
 * 
 * @author akhil
 *
 */
@Validated
public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

	List<Product> searchProducts(String title);
}
