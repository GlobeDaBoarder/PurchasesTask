package com.epam.task.purchases;


public class DiscountIfMorePurchase extends AbstractPurchase {
    private static final double QUANTITY_TO_DISCOUNT = 3;
    private final double discountPercentage;

    public DiscountIfMorePurchase(Product product, int purchasedNum, double discountPercentage) {
        super(product, purchasedNum);
        this.discountPercentage = discountPercentage;
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        if (purchasedNum >= QUANTITY_TO_DISCOUNT){
            baseCost = baseCost.mul(1 - discountPercentage/100, RoundMethods.ROUND, 0);
        }

        return baseCost;
    }
}
