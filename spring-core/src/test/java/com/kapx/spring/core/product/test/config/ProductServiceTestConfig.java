package com.kapx.spring.core.product.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kapx.spring.core.product.service.ProductService;
import com.kapx.spring.core.product.service.ProductServiceImpl;

@Configuration
public class ProductServiceTestConfig {

	@Bean
	ProductService productService() {
		return new ProductServiceImpl();
	}
}
