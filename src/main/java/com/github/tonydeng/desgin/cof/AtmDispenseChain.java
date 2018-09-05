package com.github.tonydeng.desgin.cof;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class AtmDispenseChain {
    private static final Logger log = LoggerFactory.getLogger(AtmDispenseChain.class);
    private DispenseChain c1;

    public AtmDispenseChain() {
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        AtmDispenseChain chain = new AtmDispenseChain();
        while (true) {
            int amount = 0;

            log.info("Enter amount to dispense");

            Scanner input = new Scanner(System.in);

            amount = input.nextInt();

            if (amount % 10 != 0) {
                log.info("Amount should be in multiple of 10S");
                return;
            }

            chain.c1.dispense(new Currency(amount));
        }
    }
}
