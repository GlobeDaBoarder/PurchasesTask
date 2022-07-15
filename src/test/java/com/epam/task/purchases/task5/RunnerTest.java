package com.epam.task.purchases.task5;

import com.epam.task.purchases.*;
import com.epam.task.purchases.base.BaseIOTest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

class RunnerTest extends BaseIOTest {

    @Test
    void isOutputCorrect() {
        Runner runner = new Runner();

        runner.main(null);

        assertOutEquals("Chocolate bar;2.45;3\n" +
                "Ice cream;1.90;2\n" +
                "cupcake;1.30;6\n" +
                "Protein bar;3.10;1\n" +
                "cookie;1.0;8\n" +
                "gummy;1.17;1\n" +
                "\n" +
                "\n" +
                "cookie;1.0;8\n" +
                "Chocolate bar;2.45;3\n" +
                "cupcake;1.30;6\n" +
                "gummy;1.17;1\n" +
                "Ice cream;1.90;2\n" +
                "Protein bar;3.10;1\n" +
                "Minimal cost = 3.00\n" +
                "Index of purchase with sum 5.00 : 3\n");
    }

    @Test
    void doesSortWork() {
        Product chocolateBar = new Product("Chocolate bar", new Euro(245));

        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new DiscountEveryPurchase(chocolateBar, 3),
                new DiscountEveryPurchase(chocolateBar, 2),
                new DiscountEveryPurchase(chocolateBar, 4),
                new DiscountEveryPurchase(chocolateBar, 1)
        };

        Arrays.sort(purchases);

        for (AbstractPurchase p : purchases )
            System.out.println(p);

        assertOutEquals("Chocolate bar;2.45;4\n" +
                "Chocolate bar;2.45;3\n" +
                "Chocolate bar;2.45;2\n" +
                "Chocolate bar;2.45;1\n");
    }

    @Test
    void doesSearchWork(){
        Product chocolateBar = new Product("Chocolate bar", new Euro(300));

        Runner runner = new Runner();

        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new DiscountEveryPurchase(chocolateBar, 3),
                new DiscountEveryPurchase(chocolateBar, 2),
                new DiscountEveryPurchase(chocolateBar, 4),
                new DiscountEveryPurchase(chocolateBar, 1)
        };


        Arrays.sort(purchases);

        assertEquals(runner.search(purchases, new Euro(800)), 1);
    }
}