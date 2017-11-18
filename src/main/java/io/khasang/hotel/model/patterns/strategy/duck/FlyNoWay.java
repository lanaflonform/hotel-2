package io.khasang.hotel.model.patterns.strategy.duck;

public class FlyNoWay implements Flyable {
    @Override
    public void performFly() {
        System.out.println("I can't fly");
    }
}
