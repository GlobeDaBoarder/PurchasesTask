package com.epam.mjc.stage0;

public class DeliveryFeePurchase extends AbstractPurchase {
    private static final Euro DELIVERY_FEE = new Euro(400);

    public DeliveryFeePurchase(Product product, int purchasedNum) {
        super(product, purchasedNum);
    }

    @Override
    public int getCost() {
        return super.getCost() + DELIVERY_FEE.getValue()/100;
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return super.compareTo(o);
    }
}
