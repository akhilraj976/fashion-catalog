package com.akhil.ecom.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akhil.ecom.exception.EcomException;
import com.akhil.ecom.model.Product;
import com.akhil.ecom.repository.ProductRepository;
/**
 * 
 * @author akhil
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository repo;

    @Override
    public List<Product> getAllProducts() {
    	List<Product> products = (List<Product>) repo.findAll();
    	if(products.isEmpty()){
    		throw new EcomException("No products found, Initialize the product repo");
    	}
		return products;
    }

    @Override
    public Product getProduct(long id) {
        return repo
          .findById(id)
          .orElseThrow(() -> new EcomException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

	@Override
	public List<Product> searchProducts(String title) {
		
		List<Product> productList = repo.findByTitleContainingIgnoreCase(title);
		if(productList.isEmpty()){
			productList = repo.findByBrandContainingIgnoreCase(title);
			if(productList.isEmpty()){
				productList = repo.findBytrending(true);
			}
		}
		return productList;
	}
}