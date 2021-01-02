package com.cognizant.coffee.product.impl;

import com.cognizant.coffee.product.ExtraProduct;

public class ExtraMilk extends ExtraProduct
{
    public static final double PRICE = 0.3;

    private static final String productName = "Extra Milk";

    public ExtraMilk() {
        super(productName);
    }

    @Override
    public double getPrice()
    {
        return PRICE;
    }
}
