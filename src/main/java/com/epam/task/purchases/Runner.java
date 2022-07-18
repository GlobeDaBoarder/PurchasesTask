package com.epam.task.purchases;

public class Runner {
    public static void main(String[] args) {

        Product chocolateBar = new Product("Chocolate bar", new Euro(245));
        Product iceCream = new Product("Ice cream", new Euro(190));
        Product cupcake = new Product("cupcake", new Euro(130));
        Product proteinBar = new Product("Protein bar", new Euro(310));
        Product cookie = new Product("cookie", new Euro(100));
        Product gummy = new Product("gummy", new Euro(117));


        PurchaseArray purchases = new PurchaseArray(
                new AbstractPurchase[]{
                        new DiscountEveryPurchase(chocolateBar, 3, new Euro(50)),
                        new DiscountEveryPurchase(iceCream, 2, new Euro(40)),
                        new DiscountIfMorePurchase(cupcake, 6, 0.10),
                        new DiscountIfMorePurchase(proteinBar, 1, 0.15),
                        new DeliveryFeePurchase(cookie, 8, new Euro(400)),
                        new DeliveryFeePurchase(gummy, 2, new Euro(300))
                }
        );

        purchases.printArr();

        purchases.sort();

        System.out.println();

        purchases.printArr();

        System.out.println("Minimal cost = " + purchases.getMinimalCost());

        System.out.println((purchases.search(new Euro(500)) < 0)? "No purchase with such sum":
                "Index of purchase with sum 5.00 : " + purchases.search(new Euro(500)));

    }

}
