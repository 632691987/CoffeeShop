package com.cognizant.coffee;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.product.impl.Coffee;
import com.cognizant.coffee.product.impl.OrangeJuice;
import com.cognizant.coffee.rule.BeverageFreeRule;
import com.cognizant.coffee.rule.NormalSetPriceRule;
import com.cognizant.coffee.rule.PurchaseRule;
import com.cognizant.coffee.service.PurchaseService;

@DisplayName("Scenario Set 2: Test when customer buy the 5th product")
public class TestAddFreeBeverageScenario extends CommonScenario
{
    PurchaseService purchaseService;

    @BeforeEach
    public void setup()
    {
        purchaseService = new PurchaseService();

        List<PurchaseRule> ruleList = new ArrayList<>();
        ruleList.add(new NormalSetPriceRule());
        ruleList.add(new BeverageFreeRule());
        purchaseService.setRuleList(ruleList);
    }

    @DisplayName("Scenario 1: When waiter input the free beverage, it should not count money")
    @Test
    public void test_when_waiter_input_free_beverage()
    {
        Order order = new Order();

        purchaseService.addProduct(order, new OrangeJuice(), true);
        purchaseService.addProduct(order, new OrangeJuice(), false);

        assertOrderEntrySize(order, 2);
        assertWithSpecificProductAndPrice(order, OrangeJuice.class, 0);
        assertWithSpecificProductAndPrice(order, OrangeJuice.class, OrangeJuice.PRICE);
    }

    @DisplayName("Scenario 2: When waiter input the 2nd beverage free")
    @Test
    public void test_when_waiter_input_one_free_beverage()
    {
        Order order = new Order();

        purchaseService.addProduct(order, new OrangeJuice(), false);
        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.MEDIUM), true);
        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.LARGE), false);

        assertWithSpecificProductAndPrice(order, OrangeJuice.class, OrangeJuice.PRICE);
        assertWithSpecificProductAndPrice(order, Coffee.class, 0);
        assertWithSpecificProductAndPrice(order, Coffee.class, Coffee.CoffeeType.LARGE.getPRICE());
        assertOrderEntrySize(order, 3);
    }
}
