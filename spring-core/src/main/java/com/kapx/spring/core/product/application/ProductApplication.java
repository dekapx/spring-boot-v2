package com.kapx.spring.core.product.application;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.kapx.spring.core.product.beans.Product;
import com.kapx.spring.core.product.controller.ProductController;

@SpringBootApplication
@ComponentScan("com.kapx.spring.core.product")
public class ProductApplication {

	public static void main(String[] args) {
		final ApplicationContext ctx = SpringApplication.run(ProductApplication.class, args);
		final ProductController controller = ctx.getBean(ProductController.class);
		final List<Product> products = controller.getProducts();

		products.forEach(product -> System.out.println(product.getDescription()));
	}
}
