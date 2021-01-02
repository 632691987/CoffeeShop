package com.cognizant.coffee.item;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    private List<OrderEntry> entryList = new ArrayList<>();;

    public void addOrderEntry(OrderEntry orderEntry) {
        entryList.add(orderEntry);
    }

    public List<OrderEntry> getEntryList()
    {
        return entryList;
    }

    public void printInvoice() {
        for(OrderEntry entry: entryList) {
            System.out.println(entry.toString());
        }
    }
}
