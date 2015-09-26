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

    private static final List<ItemElement> books = Lists.newArrayList(
            new Book(20, "1234"),
            new Book(100, "5678")
    );

    private static final List<ItemElement> fruits = Lists.newArrayList(
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple")
    );


    @Test
    public void testBookCalculatePrice() {

        int total = shoppingCart.calculatePrice(books);

        log.info("books total:{}", total);

        Assert.assertTrue("书籍总价计算错误", total == (95 + 20));
    }

    @Test
    public void testFruitCalculatePrice() {

        int total = shoppingCart.calculatePrice(fruits);

        log.info("fruits total:{}", total);

        Assert.assertTrue("水果总价计算错误", total == (10 * 2 + 5 * 5));
    }

    @Test
    public void testAllCalculatePrice() {
        List<ItemElement> items = Lists.newArrayList();
        items.addAll(books);
        items.addAll(fruits);

        int total = shoppingCart.calculatePrice(items);

        log.info("all items total:{}", total);

        Assert.assertTrue("所有商品总价计算错误", total == (95 + 20) + (10 * 2 + 5 * 5));
    }
}
