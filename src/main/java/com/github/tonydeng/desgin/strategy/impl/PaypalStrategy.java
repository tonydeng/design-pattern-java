package com.github.tonydeng.desgin.strategy.impl;

import com.github.tonydeng.desgin.strategy.PaymentStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/9/27.
 */
public class PaypalStrategy implements PaymentStrategy {
    private static final Logger log = LoggerFactory.getLogger(PaypalStrategy.class);

    private String email;
    private String password;

    public PaypalStrategy(String email, String pwd) {
        this.email = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) {
        log.info("{} paid using Paypal by {}", amount, email);
    }
}
