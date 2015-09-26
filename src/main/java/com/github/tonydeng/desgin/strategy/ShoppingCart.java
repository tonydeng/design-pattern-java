package com.github.tonydeng.desgin.strategy;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by tonydeng on 15/9/27.
 */
public class ShoppingCart {
    List<Item> items;

    public ShoppingCart() {
        this.items = Lists.newArrayList();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void remoteItem(Item item) {
        this.items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy payment) {
        payment.pay(calculateTotal());
    }
}
