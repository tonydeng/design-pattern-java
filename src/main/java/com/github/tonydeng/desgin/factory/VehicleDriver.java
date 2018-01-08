package com.github.tonydeng.desgin.factory;

public interface VehicleDriver {
    Vehicle getVehicle();

    default void drviceVehicle() {
        getVehicle().drive();
    }

    default void cleanVehicle() {
        getVehicle().clean();
    }

}
