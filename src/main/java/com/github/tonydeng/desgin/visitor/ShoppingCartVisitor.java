package com.github.tonydeng.desgin.visitor;

import com.github.tonydeng.desgin.visitor.item.Book;
import com.github.tonydeng.desgin.visitor.item.Fruit;

/**
 * Created by tonydeng on 15/9/26.
 */
public interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
