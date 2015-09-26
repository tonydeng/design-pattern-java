package com.github.tonydeng.desgin.visitor.item;

import com.github.tonydeng.desgin.visitor.ItemElement;
import com.github.tonydeng.desgin.visitor.ShoppingCartVisitor;

/**
 * Created by tonydeng on 15/9/26.
 */
public class Fruit implements ItemElement {

    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int pricePerKg,int wt, String nm){
        this.pricePerKg = pricePerKg;
        this.weight = wt;
        this.name = nm;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
