package io.khasang.hotel.model.patterns.strategy.duck;

public abstract class Duck {
    Flyable flyable;

    public void getInfo() {
        System.out.println("I am duck.");
    }

    public void fly() {
        flyable.performFly();
    }

}
