package com.cognizant.coffee.rule;

import java.util.List;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.item.OrderEntry;
import com.cognizant.coffee.product.Beverage;
import com.cognizant.coffee.product.ExtraProduct;
import com.cognizant.coffee.product.Product;
import com.cognizant.coffee.product.Snack;

public class ExtraFreeRule implements PurchaseRule
{
    @Override
    public void process(Order order, boolean isFree)
    {
        long beverageCount, snackCount, extraFreeCount;

        beverageCount = countProduct(order, Beverage.class);//A
        snackCount = countProduct(order, Snack.class);//B
        long promotionCount = Math.min(beverageCount, snackCount);//D
        extraFreeCount = countFreeOrderEntry(order, ExtraProduct.class);//C

        if (promotionCount > extraFreeCount)
        {
            List<OrderEntry> orderEntryList = order.getEntryList();
            for (OrderEntry _orderEntry : orderEntryList)
            {
                Product product = _orderEntry.getProduct();
                if (product instanceof ExtraProduct && Double.compare(_orderEntry.getPrice(), 0) != 0)
                {
                    _orderEntry.setPrice(0);
                    break;
                }
            }
        }

    }

    private long countProduct(Order order, Class clazz)
    {
        return order.getEntryList().stream().map(OrderEntry::getProduct).filter(p -> clazz.isInstance(p)).count();
    }

    private int countFreeOrderEntry(Order order, Class clazz)
    {
        List<OrderEntry> orderEntryList = order.getEntryList();
        int result = 0;

        for (OrderEntry orderEntry : orderEntryList)
        {
            Product product = orderEntry.getProduct();
            if (clazz.isInstance(product) && Double.compare(orderEntry.getPrice(), 0d) == 0)
            {
                result++;
            }
        }

        return result;
    }
}
