package com.epam.task.purchases.task5;

import com.epam.task.purchases.*;
import com.epam.task.purchases.base.BaseIOTest;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseArrayTest extends BaseIOTest {
    private final Product testProduct = new Product("test", new Euro(150));
    private final PurchaseArray testArr = new PurchaseArray(
            new AbstractPurchase[]{
                    new DiscountEveryPurchase(testProduct, 2, new Euro(0)),
                    new DiscountEveryPurchase(testProduct, 5, new Euro(50)),
                    new DiscountEveryPurchase(testProduct, 4, new Euro(0))
            }
    );

    @Test
    void validateSort(){
        PurchaseArray sortedArr = new PurchaseArray(
                new AbstractPurchase[]{
                        new DiscountEveryPurchase(testProduct, 4, new Euro(0)),
                        new DiscountEveryPurchase(testProduct, 5, new Euro(50)),
                        new DiscountEveryPurchase(testProduct, 2, new Euro(0))
                }
        );

        testArr.sort();

        assertEquals(sortedArr, testArr);
    }

    @Test
    void searchForCostOf6(){
        testArr.sort();
        assertEquals(0, testArr.search(new Euro(600)));
    }

    @Test
    void searchForCostOf5(){
        testArr.sort();
        assertEquals(1, testArr.search(new Euro(500)));
    }

    @Test
    void searchForCostOf3(){
        testArr.sort();
        assertEquals(2, testArr.search(new Euro(300)));
    }

    @Test
    void searchForNonExistingCostOf20(){
        testArr.sort();
        assertEquals(-1, testArr.search(new Euro(20, 0)));
    }
}