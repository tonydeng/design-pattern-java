package com.github.tonydeng.desgin.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/26.
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartVisitorImpl.class);

    /**
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
        if (log.isInfoEnabled())
            log.info("Boook ISDN::{} cost={}", book.getIsbnNumber(), cost);
        return cost;
    }
}
