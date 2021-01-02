package com.cognizant.coffee.product.impl;

import com.cognizant.coffee.product.Beverage;

public class Coffee extends Beverage
{
    public enum CoffeeType
    {
        SMALL("Small Coffee", 2.5), MEDIUM("Medium Coffee", 3.0), LARGE("Large Coffee", 3.5);

        private double PRICE;

        private String name;

        CoffeeType(String name, double PRICE)
        {
            this.name = name;
            this.PRICE = PRICE;
        }

        public double getPRICE()
        {
            return PRICE;
        }

        public String getName()
        {
            return name;
        }
    }

    private CoffeeType coffeeType;

    public Coffee(CoffeeType coffeeType)
    {
        super(coffeeType.name);
        this.coffeeType = coffeeType;
    }

    @Override
    public double getPrice()
    {
        return this.coffeeType.PRICE;
    }
}
