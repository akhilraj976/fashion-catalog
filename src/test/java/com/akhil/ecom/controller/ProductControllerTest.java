package com.akhil.ecom.controller;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.akhil.ecom.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
@Ignore
public class ProductControllerTest {
	
	@InjectMocks
	ProductController controller;
	
	@Mock
	ProductService service;

	@Before
	public void setUp() throws Exception {
		controller = new ProductController();
	}

	@Test
	public void testGetProducts() {
		assertNull(controller.getProducts());
	}

}
