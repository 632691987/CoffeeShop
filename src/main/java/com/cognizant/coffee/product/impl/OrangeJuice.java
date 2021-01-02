package com.cognizant.coffee.product.impl;

import com.cognizant.coffee.product.Beverage;

public class OrangeJuice extends Beverage
{
    public static final double PRICE = 3.95;

    private static final String productName = "Orange Juice";

    public OrangeJuice()
    {
        super(productName);
    }

    @Override
    public double getPrice()
    {
        return PRICE;
    }
}
