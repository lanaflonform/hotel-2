package io.khasang.hotel.model;

public class FlyNoWay implements Flyable {
    @Override
    public void performFly() {
        System.out.println("I can't fly");
    }
}
