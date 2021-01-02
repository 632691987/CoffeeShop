package com.cognizant.coffee.rule;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.item.OrderEntry;

public interface PurchaseRule
{
    void process(Order order, boolean isFree);

    default OrderEntry getLastOrderEntry(Order order) {
        int entrySize = order.getEntryList().size();
        if (entrySize == 0) {
            return null;
        }
        return order.getEntryList().get(entrySize-1);
    }
}
