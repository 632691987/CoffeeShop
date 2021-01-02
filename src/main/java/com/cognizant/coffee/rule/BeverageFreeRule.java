package com.cognizant.coffee.rule;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.item.OrderEntry;
import com.cognizant.coffee.product.Beverage;
import com.cognizant.coffee.product.Product;

public class BeverageFreeRule implements PurchaseRule
{
    @Override
    public void process(Order order, boolean isFree)
    {
        if (isFree) {
            OrderEntry orderEntry = getLastOrderEntry(order);
            Product product = orderEntry.getProduct();
            if (product instanceof Beverage) {
                orderEntry.setPrice(0d);
            }
        }
    }
}
