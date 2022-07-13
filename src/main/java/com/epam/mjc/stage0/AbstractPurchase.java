package com.epam.mjc.stage0;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{
    protected Product product;
    protected int purchasedNum;

    public AbstractPurchase(Product product, int purchasedNum) {
        this.product = product;
        this.purchasedNum = purchasedNum;
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return Integer.compare(o.getCost(), this.getCost());
    }

    public int getCost(){
        return purchasedNum * product.getPrice().getValue()/100;
    }

    @Override
    public String toString() {
        return product.getName() + ';' + product.getPrice().getValue()/100 + '.' + product.getPrice().getValue()%100 + ';' +  purchasedNum;
    }

}
