package com.akhil.ecom.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.akhil.ecom.model.Product;
/**
 * 
 * @author akhil
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByTitleContaining(String title);
	
	List<Product> findByBrandContaining(String brand);
}