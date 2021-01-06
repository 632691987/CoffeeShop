package com.cognizant.coffee;

import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cognizant.coffee.item.Order;
import com.cognizant.coffee.product.impl.BaconRoll;
import com.cognizant.coffee.product.impl.Coffee;
import com.cognizant.coffee.product.impl.ExtraMilk;
import com.cognizant.coffee.product.impl.FoamedMilk;
import com.cognizant.coffee.product.impl.OrangeJuice;
import com.cognizant.coffee.product.impl.RoastCoffee;
import com.cognizant.coffee.service.PurchaseService;

@DisplayName("Scenario Set 3: Test when customer add extra products")
public class TestAddExtraProductScenario extends CommonScenario
{
    PurchaseService purchaseService;

    @BeforeEach
    public void setup()
    {
        purchaseService = new PurchaseService();
    }

    @DisplayName("Scenario 1: Test the extra product is free when customer buy a beverage and a snack")
    @Test
    public void testCustomerBuyABeverageAndASnack()
    {
        Order order = new Order();

        purchaseService.addProduct(order, new OrangeJuice());
        purchaseService.addProduct(order, new BaconRoll());
        purchaseService.addProduct(order, new ExtraMilk());

        assertOrderEntrySize(order, 3);
        assertWithSpecificProductAndPrice(order, OrangeJuice.class, OrangeJuice.PRICE);
        assertWithSpecificProductAndPrice(order, BaconRoll.class, BaconRoll.PRICE);
        assertWithSpecificProductAndPrice(order, ExtraMilk.class, 0);
    }

    @DisplayName("Scenario 2: Stimulate random add random product and check how many extra beverage is free")
    @Test
    public void testCustomerRandomBuyProduct()
    {
        for (int loop = 0; loop < 10; loop++)
        {
            Order order = new Order();

            int customerByProductsCount = new Random().nextInt(25);

            int beverageCount = 0;
            int snackCount = 0;
            int extraCount = 0;

            for (int index = 0; index < customerByProductsCount; index++)
            {

                int productType = new Random().nextInt(8);

                switch (productType)
                {
                    case 0:
                    {
                        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.LARGE));
                        beverageCount++;
                        break;
                    }
                    case 1:
                    {
                        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.MEDIUM));
                        beverageCount++;
                        break;
                    }
                    case 2:
                    {
                        purchaseService.addProduct(order, new Coffee(Coffee.CoffeeType.SMALL));
                        beverageCount++;
                        break;
                    }
                    case 3:
                    {
                        purchaseService.addProduct(order, new BaconRoll());
                        snackCount++;
                        break;
                    }
                    case 4:
                    {
                        purchaseService.addProduct(order, new OrangeJuice());
                        beverageCount++;
                        break;
                    }
                    case 5:
                    {
                        purchaseService.addProduct(order, new ExtraMilk());
                        extraCount++;
                        break;
                    }
                    case 6:
                    {
                        purchaseService.addProduct(order, new FoamedMilk());
                        extraCount++;
                        break;
                    }
                    case 7:
                    {
                        purchaseService.addProduct(order, new RoastCoffee());
                        extraCount++;
                        break;
                    }
                }

            }

            int promotionCount = Math.min(beverageCount, snackCount);
            int freeCount = (int) countFreeExtraOrderEntries(order);
            Assertions.assertEquals(Math.min(promotionCount, extraCount), freeCount);
        }
    }

}
