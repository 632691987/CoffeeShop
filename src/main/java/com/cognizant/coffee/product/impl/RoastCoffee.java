package com.cognizant.coffee.product.impl;

import com.cognizant.coffee.product.ExtraProduct;

public class RoastCoffee extends ExtraProduct
{
    public static final double PRICE = 0.9;

    private static final String productName = "Roast Coffee";

    public RoastCoffee() {
        super(productName);
    }

    @Override
    public double getPrice()
    {
        return PRICE;
    }
}
