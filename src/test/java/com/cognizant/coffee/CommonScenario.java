package com.cognizant.coffee;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.item.OrderEntry;
import com.cognizant.coffee.product.ExtraProduct;
import com.cognizant.coffee.product.Product;
import com.cognizant.coffee.product.impl.Coffee;

public class CommonScenario
{
    protected void assertWithSpecificProductAndPrice(Order order, Class clazz, double price) {
        List<OrderEntry> orderEntryList = order.getEntryList();
        for (int index = 0; index < orderEntryList.size(); index++) {
            OrderEntry orderEntry = orderEntryList.get(index);
            Product product = orderEntry.getProduct();
            if (clazz.isInstance(product)) {
                if (Double.compare(orderEntry.getPrice(), price) == 0) {
                    return;
                }
            }
        }
        Assertions.fail("No product with price " + price);
    }

    protected long countFreeExtraOrderEntries(Order order) {
        List<OrderEntry> orderEntryList = order.getEntryList().stream().filter(entry -> Double.compare(entry.getPrice(), 0) == 0).collect(Collectors.toList());
        return orderEntryList.stream().map(entry->entry.getProduct()).filter(p -> ExtraProduct.class.isInstance(p)).count();
    }

    protected void assertOrderEntrySize(Order order, int size) {
        Assertions.assertTrue(order.getEntryList().size() == size);
    }
}
