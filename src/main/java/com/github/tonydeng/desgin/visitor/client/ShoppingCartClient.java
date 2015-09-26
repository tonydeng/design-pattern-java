package com.github.tonydeng.desgin.visitor.client;

import com.github.tonydeng.desgin.visitor.ItemElement;
import com.github.tonydeng.desgin.visitor.ShoppingCartVisitor;
import com.github.tonydeng.desgin.visitor.impl.ShoppingCartVisitorImpl;

import java.util.List;

/**
 * Created by tonydeng on 15/9/26.
 */
public class ShoppingCartClient {
    /**
     * 计算所有商品的总价
     *
     * @param items
     * @return
     */
    public int calculatePrice(List<ItemElement> items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();

        int sum = 0;
        for (ItemElement item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
