package com.epam.mjc.stage0;

public class DiscountIfMorePurchase extends AbstractPurchase {
    private static final double DISCOUNT_PERCENTAGE = 0.2;
    private static final double QUANTITY_TO_DISCOUNT = 3;

    public DiscountIfMorePurchase(Product product, int purchasedNum) {
        super(product, purchasedNum);
    }

    @Override
    public int getCost() {
        if(purchasedNum >= QUANTITY_TO_DISCOUNT){
            return (int) ((1.0-DISCOUNT_PERCENTAGE) * super.getCost());
        }

        return super.getCost();
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return super.compareTo(o);
    }
}
