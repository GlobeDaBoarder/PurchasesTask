package com.epam.task.purchases;


public class DiscountIfMorePurchase extends AbstractPurchase {
    private static final double DISCOUNT_PERCENTAGE = 0.2;
    private static final double QUANTITY_TO_DISCOUNT = 3;

    public DiscountIfMorePurchase(Product product, int purchasedNum) {
        super(product, purchasedNum);
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        if (purchasedNum >= QUANTITY_TO_DISCOUNT){
            return baseCost.mul(1 - DISCOUNT_PERCENTAGE, RoundMethods.ROUND, 0);
        }

        return baseCost;
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return super.compareTo(o);
    }
}
