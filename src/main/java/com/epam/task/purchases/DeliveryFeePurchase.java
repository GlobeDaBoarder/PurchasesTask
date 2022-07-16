package com.epam.task.purchases;

public class DeliveryFeePurchase extends AbstractPurchase {
    private final Euro deliveryFee;

    public DeliveryFeePurchase(Product product, int purchasedNum, Euro deliveryFee) {
        super(product, purchasedNum);
        this.deliveryFee = deliveryFee;
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        return baseCost.add(deliveryFee);
    }
}
