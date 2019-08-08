package com.akhil.ecom.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.akhil.ecom.exception.EcomException;
import com.akhil.ecom.model.Product;
import com.akhil.ecom.repository.ProductRepository;

/**
 * 
 * @author akhil
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService service = new ProductServiceImpl();

	@Mock
	private ProductRepository repo;

	private List<Product> products;

	@Before
	public void setUp() {
		products = new ArrayList<>();
		products.add(new Product(1L, "Jeans", 300.00, "Levis", "jeans.jpg", true));
		products.add(new Product(2L, "Tops", 200.00, "Prada", "tops.jpg", false));
		products.add(new Product(3L, "Sweater", 100.00, "US Polo", "sweater.jpg", false));
		products.add(new Product(4L, "jacket", 500.00, "Us Polo", "jacket.jpg", true));
		products.add(new Product(5L, "Jeans", 300.00, "LevisJeans", "jeans.jpg", true));
	}

	@Test
	public void getAllProductsTest() {
		Mockito.when(repo.findAll()).thenReturn(products);
		List<Product> productList = service.getAllProducts();
		assertNotNull(productList);
	}

	@Test(expected = EcomException.class)
	public void getAllProductsEmptyTest() {
		Mockito.when(repo.findAll()).thenReturn(new ArrayList<>());
		service.getAllProducts();
	}

	@Test
	public void getProductTest() {
		Optional<Product> opt = Optional.of(products.get(0));
		Mockito.when(repo.findById(Mockito.anyLong())).thenReturn(opt);
		assertEquals("Jeans", service.getProduct(1L).getTitle());
	}

	@Test(expected = EcomException.class)
	public void getProductTestNotFound() {
		Optional<Product> opt = Optional.ofNullable(null);
		Mockito.when(repo.findById(Mockito.anyLong())).thenReturn(opt);
		service.getProduct(1L);
	}

	@Test
	public void searchProductsWithTitleFoundTest() {
		products.remove(1);
		products.remove(1);
		products.remove(1);
		Mockito.when(repo.findByTitleContainingIgnoreCase(Mockito.anyString())).thenReturn(products);
		List<Product> productList = service.searchProducts("Jeans");
		assertNotNull(productList);
		assertEquals(2, productList.size());
		assertEquals("Jeans", productList.get(0).getTitle());
	}

	@Test
	public void searchProductsWithTitleNotFoundTest() {
		products.remove(0);products.remove(3);
		Mockito.when(repo.findByTitleContainingIgnoreCase(Mockito.anyString())).thenReturn(products);
		List<Product> productList = service.searchProducts("Jeans");
		assertNotNull(productList);
		assertEquals(3, productList.size());
		assertNotEquals("Jeans", productList.get(0).getTitle());
	}
}
