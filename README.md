###Technique design description

1. At the beginning. Application would create an new empty order.
2. Each time customer order a new order, a service class will accept this new order entry, then rule for three rules one by one.
   * The first is set the order entry price 
   * The second is set he product price to zero if this is the 5th beverage. As requirement said that there is a stamp card but the application would not store it, so I service
allow one normal offering and beverage to free any time, just by calling with the relative parameter.
   * The third rule is once the customer order a beverage and a snack, then one extra beverage would be free.
3. Finally can call the order print the invoice anytime.

###Main API
1, For each product, it is located in "com.cognizant.coffee.product" package
2, Service class is "com.cognizant.coffee.service.PurchaseService", it can accept customer ordered item, and call rules to process this new order entry.
3, Finally, if want to print the order, then can direct call the API order.printInvoice
