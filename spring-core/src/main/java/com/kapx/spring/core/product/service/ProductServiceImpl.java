package com.kapx.spring.core.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kapx.spring.core.product.beans.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> listProducts() {
		final ArrayList<Product> products = new ArrayList<>(2);
		products.add(new Product("Product 1 description"));
		products.add(new Product("Product 2 description"));
		return products;
	}
}
