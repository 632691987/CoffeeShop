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
        double total = 0d;
        String currencyCode = "";

        if (entryList != null && entryList.size() > 0) {
            currencyCode = entryList.get(0).getProduct().getCurrency().getCurrencyCode();
        }

        for(OrderEntry entry: entryList) {
            total = total + entry.getPrice();
            System.out.println(entry.toString());
        }
        System.out.println("..........................................");
        System.out.println(String.format("%-15s                 %6.2f %s", "Total", total, currencyCode));
    }
}
