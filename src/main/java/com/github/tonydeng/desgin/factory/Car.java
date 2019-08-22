package com.github.tonydeng.desgin.factory;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Car implements Vehicle {

    @Override
    public void drive() {
        log.info("Driving a car...");
    }

    @Override
    public void clean() {
        log.info("Cleaning a car...");
    }
}
