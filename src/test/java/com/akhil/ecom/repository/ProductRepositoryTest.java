package com.akhil.ecom.repository;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.akhil.ecom.model.Product;
/**
 * 
 * @author akhil
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void testCreateProductAndClear() {
        Product product = new Product(1L, "Blanket", 300.00, "Gucci", "blanket.jpg", false);
        repository.save(product);
        assertTrue(repository.existsById(product.getId()));
        repository.delete(product);
        assertFalse(repository.existsById(product.getId()));
    }
}
