package com.github.tonydeng.desgin.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/26.
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartVisitorImpl.class);

    /**
     * 单本书成交价
     *
     * @param book
     * @return
     */
    @Override
    public int visit(Book book) {
        int cost = 0;

        if (book.getPrice() > 50) {
            cost = book.getPrice() - 5;
        } else {
            cost = book.getPrice();
        }
        if (log.isDebugEnabled())
            log.debug("Boook ISDN::{} cost={}", book.getIsbnNumber(), cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        if (log.isDebugEnabled())
            log.debug("{} cost={}", fruit.getName(), cost);

        return cost;
    }
}
