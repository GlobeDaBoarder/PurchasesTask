package com.epam.task.purchases;

public class DeliveryFeePurchase extends AbstractPurchase {
    private static final Euro DELIVERY_FEE = new Euro(400);

    public DeliveryFeePurchase(Product product, int purchasedNum) {
        super(product, purchasedNum);
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        return baseCost.add(DELIVERY_FEE);
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return super.compareTo(o);
    }
}
