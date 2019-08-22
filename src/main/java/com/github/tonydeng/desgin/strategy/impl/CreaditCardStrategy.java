package com.github.tonydeng.desgin.strategy.impl;

import com.github.tonydeng.desgin.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class CreaditCardStrategy implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreaditCardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        log.info("{} paid with credit/debit card by {}", amount, name);
    }
}
