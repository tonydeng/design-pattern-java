package com.github.tonydeng.desgin.visitor;

/**
 * Created by tonydeng on 15/9/26.
 */
public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
