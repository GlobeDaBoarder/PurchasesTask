package com.epam.task.purchases;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{
    protected final Product product;
    protected final int purchasedNum;

    public AbstractPurchase(Product product, int purchasedNum) {
        this.product = product;
        this.purchasedNum = purchasedNum;
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return Integer.compare(o.getCost().getValue(), this.getCost().getValue());
    }

    protected abstract Euro getFinalCost(Euro baseCost);

    public Euro getCost(){
        Euro baseCost = product.getPrice().mul(purchasedNum);
        Euro finalCost = getFinalCost(baseCost);
		return finalCost.round(RoundMethods.FLOOR, 2);
    }


    @Override
    public String toString() {
        return product.getName() + ';' + product.getPrice().getValue()/100 + '.' + product.getPrice().getValue()%100 + ';' +  purchasedNum;
    }

}
