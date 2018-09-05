package com.github.tonydeng.desgin.cor;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(Currency currency);
}
