package com.cognizant.coffee.product.impl;

import com.cognizant.coffee.product.ExtraProduct;

public class FoamedMilk extends ExtraProduct
{
    public static final double PRICE = 0.5;

    private static final String productName = "Foamed Milk";

    public FoamedMilk() {
        super(productName);
    }

    @Override
    public double getPrice()
    {
        return PRICE;
    }
}
