package com.kapx.spring.core.product.service;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kapx.spring.core.product.beans.Product;
import com.kapx.spring.core.product.test.config.ProductServiceTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ProductServiceTestConfig.class })
public class ProductServiceImplIT {
	@Autowired
	private ProductService productService;

	@Test
	public void listProducts_returnProducts() {
		final List<Product> products = productService.listProducts();
		assertFalse(products.isEmpty());
	}
}
