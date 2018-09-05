package com.github.tonydeng.desgin.cof;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dollar20Dispenser implements DispenseChain {
    private static final Logger log = LoggerFactory.getLogger(Dollar20Dispenser.class);
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 20) {
            int num = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;

            log.info("Dispensing {} 20$ note");
            if(remainder !=0 ){
                this.chain.dispense(new Currency(remainder));
            }
        }else {
            this.chain.dispense(currency);
        }
    }
}
