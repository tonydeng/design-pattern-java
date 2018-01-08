package com.github.tonydeng.desgin.factory;

import org.junit.Test;

public class FactoryMethodPatternTest {

    @Test
    public void testFactory() {
        FactoryMethodPattern.handleVehicle(Car::new);
        FactoryMethodPattern.handleVehicle(Bus::new);
        FactoryMethodPattern.handleVehicle(Car::new);
    }
}
