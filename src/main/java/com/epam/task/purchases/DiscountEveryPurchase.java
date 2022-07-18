package com.epam.task.purchases;

public class DiscountEveryPurchase extends AbstractPurchase{
    private final Euro discount;

    public DiscountEveryPurchase(Product product, int purchasedNum, Euro discount) {
        super(product, purchasedNum);
        this.discount = discount;
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        return baseCost.sub(discount.mul(purchasedNum));
    }
}
