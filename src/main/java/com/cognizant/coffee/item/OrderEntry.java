package com.cognizant.coffee.item;

import com.cognizant.coffee.product.Product;

public class OrderEntry
{
    private Product product;

    private double price;

    public OrderEntry(Product product) {
        this.product = product;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return String.format("%-15s.................%6.2f %s", product.getProductName(), this.price, product.getCurrency().getCurrencyCode());
    }
}
