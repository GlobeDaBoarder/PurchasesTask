package com.epam.task.purchases;

import java.util.Arrays;
import java.util.Comparator;

public class PurchaseArray {
    private final AbstractPurchase[] purchases;

    public PurchaseArray(AbstractPurchase[] purchases) {
        this.purchases = purchases;
    }

    public void sort(){
        Arrays.sort(purchases);
    }

    public int search( Euro searchValue) {
        Comparator<AbstractPurchase> comparator = AbstractPurchase::compareTo;

        return Arrays.binarySearch(
                purchases,
                new DiscountIfMorePurchase(new Product(null, new Euro(searchValue)), 1, 0.10),
                comparator);
    }

    public Euro getMinimalCost(){
        return purchases[purchases.length - 1].getCost();
    }

    public void printArr(){
        System.out.println(this);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(AbstractPurchase p : purchases){
            res.append(p).append("\n");
        }
        return res.toString();
    }
}
