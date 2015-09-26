package com.github.tonydeng.desgin.visitor;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by tonydeng on 15/9/26.
 */
public class ShoppingCartClientTest {
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartClientTest.class);
    private ShoppingCartClient shoppingCart = new ShoppingCartClient();

    @Test
    public void testBookCalculatePrice() {
        List<ItemElement> items = Lists.newArrayList(
                new Book(20, "1234"),
                new Book(100, "5678")
        );
        int total = shoppingCart.calculatePrice(items);

        log.info("books total:{}", total);

        Assert.assertTrue("计算错误", total == (95 + 20));
    }

    @Test
    public void testFruitCalculatePrice() {
        List<ItemElement> items = Lists.newArrayList(
                new Fruit(10, 2, "Banana"),
                new Fruit(5, 5, "Apple")
        );

        int total = shoppingCart.calculatePrice(items);

        log.info("fruit total:{}", total);

        Assert.assertTrue("计算错误", total == (10 * 2 + 5 * 5));
    }
}
