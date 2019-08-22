package com.github.tonydeng.desgin.visitor;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.visitor.client.ShoppingCartClient;
import com.github.tonydeng.desgin.visitor.item.Book;
import com.github.tonydeng.desgin.visitor.item.Fruit;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by tonydeng on 15/9/26.
 */
@Slf4j
public class ShoppingCartClientTest extends BaseTest {
    private ShoppingCartClient shoppingCart = new ShoppingCartClient();

    private static final List<ItemElement> books = Lists.newArrayList(
            new Book(20, "《少有人走的路》"),
            new Book(100, "《设计模式》")
    );
    private static final List<ItemElement> fruits = Lists.newArrayList(
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple")
    );

    @Test
    public void testBookCalculatePrice() {
        int total = shoppingCart.calculatePrice(books);
        log.info("books total:{}", total);
        Assertions.assertTrue(total == (95 + 20), "书籍总价计算错误");
    }

    @Test
    public void testFruitCalculatePrice() {
        int total = shoppingCart.calculatePrice(fruits);
        log.info("fruits total:{}", total);
        Assertions.assertTrue(total == (10 * 2 + 5 * 5), "水果总价计算错误");
    }

    @Test
    public void testAllCalculatePrice() {
        List<ItemElement> items = Lists.newArrayList();
        items.addAll(books);
        items.addAll(fruits);
        int total = shoppingCart.calculatePrice(items);
        log.info("all items total:{}", total);
        Assertions.assertTrue(total == (95 + 20) + (10 * 2 + 5 * 5), "所有商品总价计算错误");
    }
}
