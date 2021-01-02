package com.cognizant.coffee.rule;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.item.OrderEntry;
import com.cognizant.coffee.product.Product;

public class NormalSetPriceRule implements PurchaseRule
{
    @Override
    public void process(Order order, boolean isFree)
    {
        OrderEntry orderEntry = getLastOrderEntry(order);
        Product product = orderEntry.getProduct();
        orderEntry.setPrice(product.getPrice());
    }
}
