package com.github.tonydeng.desgin.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bus implements Vehicle {
    private final static Logger log = LoggerFactory.getLogger(Bus.class);

    @Override
    public void drive() {
        log.info("Driving a bus...");
    }

    @Override
    public void clean() {
        log.info("Cleaning a bus...");
    }
}
