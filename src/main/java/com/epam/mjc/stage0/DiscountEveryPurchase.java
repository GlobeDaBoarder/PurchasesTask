package com.epam.mjc.stage0;

public class DiscountEveryPurchase extends AbstractPurchase{
    private static final double DISCOUNT_PERCENTAGE = 0.1;

    public DiscountEveryPurchase(Product product, int purchasedNum) {
        super(product, purchasedNum);
    }

    @Override
    public int getCost() {
        return (int) ((1.0 - DISCOUNT_PERCENTAGE) * super.getCost());
    }



    @Override
    public int compareTo(AbstractPurchase o) {
        return super.compareTo(o);
    }
}
