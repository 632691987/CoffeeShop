package com.cognizant.coffee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.item.OrderEntry;
import com.cognizant.coffee.product.Product;
import com.cognizant.coffee.rule.BeverageFreeRule;
import com.cognizant.coffee.rule.ExtraFreeRule;
import com.cognizant.coffee.rule.NormalSetPriceRule;
import com.cognizant.coffee.rule.PurchaseRule;

public class PurchaseService
{
    private List<PurchaseRule> ruleList = new ArrayList<>();

    public PurchaseService() {
        ruleList.add(new NormalSetPriceRule());
        ruleList.add(new BeverageFreeRule());
        ruleList.add(new ExtraFreeRule());
    }

    /**
     *
     * Considering that customer may have bought some beverage before, and mark into stamp card,
     * so it could possible that when customer buy the any cups count to be the 5th beverage and set to free
     *
     */
    public void addProduct(Order order, Product product, boolean isFree) {
        order = Optional.ofNullable(order).orElse(new Order());

        OrderEntry orderEntry = new OrderEntry(product);
        order.addOrderEntry(orderEntry);
        for (PurchaseRule rule : ruleList) {
            rule.process(order, isFree);
        }
    }

    public void addProduct(Order order, Product product) {
        addProduct(order, product, false);
    }

    public List<PurchaseRule> getRuleList()
    {
        return ruleList;
    }

    public void setRuleList(List<PurchaseRule> ruleList)
    {
        this.ruleList = ruleList;
    }
}
