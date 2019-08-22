package com.github.tonydeng.desgin.strategy.impl;

import com.github.tonydeng.desgin.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by tonydeng on 15/9/27.
 */
@Slf4j
public class PaypalStrategy implements PaymentStrategy {

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
