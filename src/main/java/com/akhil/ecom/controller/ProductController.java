package com.akhil.ecom.controller;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.ecom.model.Product;
import com.akhil.ecom.service.ProductService;
/**
 * 
 * @author akhil
 *
 */
@RestController
@RequestMapping("/fashion/v1/products")
public class ProductController {

	@Autowired
    private ProductService productService;

    @GetMapping(value = { "", "/" })
    public @NotNull List<Product> getProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping(value = "/search")
    public List<Product> getProductsByKey(@RequestParam String title) {
        return productService.searchProducts(title);
    }
}