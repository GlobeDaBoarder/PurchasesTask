package com.epam.mjc.stage0;

import java.util.Arrays;
import java.util.Comparator;

public class Runner {
    public static int search(AbstractPurchase[] purchases) {
        Comparator<AbstractPurchase> comparator = AbstractPurchase::compareTo;

        return Arrays.binarySearch(
                purchases,
                new DiscountIfMorePurchase(new Product(null, new Euro(500)), 1),
                comparator);
    }

    public static void main(String[] args) {

        Product chocolateBar = new Product("Chocolate bar", new Euro(245));
        Product iceCream = new Product("Ice cream", new Euro(190));
        Product cupcake = new Product("cupcake", new Euro(130));
        Product proteinBar = new Product("Protein bar", new Euro(310));
        Product cookie = new Product("cookie ", new Euro(100));
        Product gummy = new Product("gummy", new Euro(117));


        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new DiscountEveryPurchase(chocolateBar, 3),
                new DiscountEveryPurchase(iceCream, 2),
                new DiscountIfMorePurchase(cupcake, 6),
                new DiscountIfMorePurchase(proteinBar, 1),
                new DeliveryFeePurchase(cookie, 8),
                new DeliveryFeePurchase(gummy, 1)
        };

        for (AbstractPurchase p : purchases) {
            System.out.println(p.getCost());
        }

        Arrays.sort(purchases);
        System.out.println("\n");

        for (AbstractPurchase p : purchases) {
            System.out.println(p.getCost());
        }

        System.out.println("Minimal cost = " + purchases[purchases.length - 1].getCost());

        System.out.println((search(purchases) == -1)? "No purchase with such sum":
                "Index of purchase with sum 5.00 : " + search(purchases));
    }
}
