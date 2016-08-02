package com.kapx.microservice.product.domain;

public class Product {
    private long id;
    private String name;
    private String type;
    private double price;

    public Product(final long id, final String name, final String type, final double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
