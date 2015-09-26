package com.github.tonydeng.desgin.strategy.impl;

import com.github.tonydeng.desgin.strategy.PaymentStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
public class CreaditCardStrategy implements PaymentStrategy {
    private static final Logger log = LoggerFactory.getLogger(CreaditCardStrategy.class);

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreaditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        log.info("{} paid with credit/debit card",amount);
    }
}
