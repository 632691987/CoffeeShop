package com.cognizant.coffee.product.impl;

import com.cognizant.coffee.product.Snack;

public class BaconRoll extends Snack
{
    public static final double PRICE = 4.5;

    private static final String productName = "Bacon Roll";

    public BaconRoll()
    {
        super(productName);
    }

    @Override
    public double getPrice()
    {
        return PRICE;
    }
}
