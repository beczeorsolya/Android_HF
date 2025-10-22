package com.example.androidhazi_3_2;

public class Product {
    String name;
    String code;
    String price;

    public Product(String name, String code, String price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPrice() {
        return price;
    }
}
