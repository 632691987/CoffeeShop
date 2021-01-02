package com.cognizant.coffee.product;

import java.util.Currency;

public abstract class Product
{
    private final Currency currency = Currency.getInstance("CHF");

    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public abstract double getPrice();

    public Currency getCurrency()
    {
        return currency;
    }
}
