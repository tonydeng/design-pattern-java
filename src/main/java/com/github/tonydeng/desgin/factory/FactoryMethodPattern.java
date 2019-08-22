package com.github.tonydeng.desgin.factory;


import lombok.extern.slf4j.Slf4j;
@Slf4j
public class FactoryMethodPattern {

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
