package com.kapx.spring.core.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kapx.spring.core.product.beans.Product;
import com.kapx.spring.core.product.service.ProductService;

@Controller("productController")
public class ProductController {

	@Autowired
	private ProductService productService;

	public List<Product> getProducts() {
		return productService.listProducts();
	}

}
