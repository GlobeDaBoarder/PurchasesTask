package com.epam.task.purchases;

public class DiscountEveryPurchase extends AbstractPurchase{
    private static final double DISCOUNT_PERCENTAGE = 0.1;

    public DiscountEveryPurchase(Product product, int purchasedNum) {
        super(product, purchasedNum);
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        return baseCost.mul(1 - DISCOUNT_PERCENTAGE, RoundMethods.ROUND, 0);
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return super.compareTo(o);
    }
}
