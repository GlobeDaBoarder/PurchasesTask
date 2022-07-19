package com.epam.task.purchases.task5;

import com.epam.task.purchases.Euro;
import com.epam.task.purchases.Product;
import com.epam.task.purchases.base.BaseIOTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest extends BaseIOTest {
    Product testProduct1 = new Product("test", new Euro(100));
    Product testProduct2 = new Product("test", new Euro(100));
    Product testProduct3 = new Product("test3", new Euro(140));

    @Test
    void productsEqual(){
        assertEquals(testProduct1, testProduct2);
    }

    @Test
    void productsNotEquals(){
        assertNotEquals(testProduct1, testProduct3);
    }
}
