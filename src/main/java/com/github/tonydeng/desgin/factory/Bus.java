package com.github.tonydeng.desgin.factory;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Bus implements Vehicle {

    @Override
    public void drive() {
        log.info("Driving a bus...");
    }

    @Override
    public void clean() {
        log.info("Cleaning a bus...");
    }
}
