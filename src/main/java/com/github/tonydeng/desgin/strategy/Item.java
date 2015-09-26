package com.github.tonydeng.desgin.strategy;

/**
 * Created by tonydeng on 15/9/27.
 */
public class Item {
    private String upcode;
    private int price;

    public Item(String upc, int cost) {
        this.upcode = upc;
        this.price = cost;
    }

    public int getPrice() {
        return price;
    }

    public String getUpcode() {

        return upcode;
    }
}
