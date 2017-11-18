package io.khasang.hotel.model.patterns.strategy.duck;

public class FlyWithWings implements Flyable {
    @Override
    public void performFly() {
        System.out.println("I am fly.");
    }
}
