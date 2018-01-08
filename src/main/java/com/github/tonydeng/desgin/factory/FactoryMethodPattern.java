package com.github.tonydeng.desgin.factory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryMethodPattern {
    private static final Logger log = LoggerFactory.getLogger(FactoryMethodPattern.class);

    public static void main(String[] args) {
        handleVehicle(Car::new);
        handleVehicle(Bus::new);
    }

    static void handleVehicle(VehicleDriver driver) {
        log.info("Handling a new vehicle...");
        driver.drviceVehicle();
        driver.cleanVehicle();
    }
}
