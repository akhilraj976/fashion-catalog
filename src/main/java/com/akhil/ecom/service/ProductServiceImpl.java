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
        return (List<Product>) repo.findAll();
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
		
		List<Product> productList = repo.findByTitleContaining(title);
		if(null == productList){
			productList = repo.findByBrandContaining(title);
		}
		return productList;
	}
}