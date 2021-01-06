package com.cognizant.coffee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.product.impl.BaconRoll;
import com.cognizant.coffee.product.impl.Coffee;
import com.cognizant.coffee.product.impl.OrangeJuice;
import com.cognizant.coffee.service.PurchaseService;

@DisplayName("Scenario Set 1: Test when customer add normal offering products")
public class TestAddNormalProductScenario extends CommonScenario
{
    PurchaseService purchaseService;

    @BeforeEach
    public void setup()
    {
        purchaseService = new PurchaseService();
    }

    @DisplayName("Scenario 1A: Test when customer add large coffee")
    @Test
    public void test_when_customer_add_large_coffee()
    {
        Order order = new Order();
        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.LARGE));

        assertOrderEntrySize(order, 1);
        assertWithSpecificProductAndPrice(order, Coffee.class, Coffee.CoffeeType.LARGE.getPRICE());
        order.printInvoice();
    }

    @DisplayName("Scenario 1B: Test when customer add medium coffee")
    @Test
    public void test_when_customer_add_medium_coffee()
    {
        Order order = new Order();
        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.MEDIUM));

        assertOrderEntrySize(order, 1);
        assertWithSpecificProductAndPrice(order, Coffee.class, Coffee.CoffeeType.MEDIUM.getPRICE());
        order.printInvoice();
    }

    @DisplayName("Scenario 1C: Test when customer add small coffee")
    @Test
    public void test_when_customer_add_small_coffee()
    {
        Order order = new Order();
        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.SMALL));

        assertOrderEntrySize(order, 1);
        assertWithSpecificProductAndPrice(order, Coffee.class, Coffee.CoffeeType.SMALL.getPRICE());
        order.printInvoice();
    }

    @DisplayName("Scenario 2: Test when customer add bacon roll")
    @Test
    public void test_when_customer_add_bacon_roll()
    {
        Order order = new Order();

        purchaseService.addProduct(order, new BaconRoll());

        assertOrderEntrySize(order, 1);
        assertWithSpecificProductAndPrice(order, BaconRoll.class, BaconRoll.PRICE);
        order.printInvoice();
    }

    @DisplayName("Scenario 3: Test when customer add orange juice")
    @Test
    public void test_when_customer_add_orange_juice()
    {
        Order order = new Order();

        purchaseService.addProduct(order, new OrangeJuice());

        assertOrderEntrySize(order, 1);
        assertWithSpecificProductAndPrice(order, OrangeJuice.class, OrangeJuice.PRICE);
        order.printInvoice();
    }

    @DisplayName("Scenario 4: Test when customer buy multiple different products")
    @Test
    public void test_when_customer_buy_multiple_products()
    {
        Order order = new Order();

        purchaseService.addProduct(order, new BaconRoll());
        purchaseService.addProduct(order, new OrangeJuice());
        purchaseService.addProduct(order, new BaconRoll());
        purchaseService.addProduct(order, new OrangeJuice());
        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.MEDIUM));
        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.SMALL));
        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.LARGE));

        assertOrderEntrySize(order, 7);
        assertWithSpecificProductAndPrice(order, BaconRoll.class, BaconRoll.PRICE);
        assertWithSpecificProductAndPrice(order, OrangeJuice.class, OrangeJuice.PRICE);
        assertWithSpecificProductAndPrice(order, Coffee.class, Coffee.CoffeeType.LARGE.getPRICE());
        assertWithSpecificProductAndPrice(order, Coffee.class, Coffee.CoffeeType.MEDIUM.getPRICE());
        assertWithSpecificProductAndPrice(order, Coffee.class, Coffee.CoffeeType.SMALL.getPRICE());
        order.printInvoice();
    }

    @DisplayName("Scenario 5: Test if order is set to null")
    @Test
    public void testOrderArgumentSetToNull()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            purchaseService.addProduct(null, new BaconRoll());
        });
    }
}
