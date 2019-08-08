package com.akhil.ecom.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.akhil.ecom.EcomApplication;
import com.akhil.ecom.model.Product;
import com.akhil.ecom.service.ProductService;

/**
 * 
 * @author akhil
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class ProductIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	EcomApplication app;

	@Autowired
	ProductService service;

	@Before
	public void setUp() {

	}

	@Test
	public void getProductsTest() throws Exception {
		mockMvc.perform(get("/fashion/v1/products").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void searchProductsTest() throws Exception {
		mockMvc.perform(
				get("/fashion/v1/products/search").contentType(MediaType.APPLICATION_JSON).param("title", "Jeans"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").exists());
		
		
	}

	@Test
	public void testSaveInitialProductsData() {
		List<Product> productListInitial = service.getAllProducts();
		app.runner(service);
		List<Product> productListPost = service.getAllProducts();
		assertTrue(productListInitial.size() == productListPost.size());
	}
}
