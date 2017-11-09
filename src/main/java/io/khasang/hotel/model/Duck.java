package io.khasang.hotel.model;

public abstract class Duck {
    Flyable flyable;

    public void getInfo() {
        System.out.println("I am duck.");
    }

    public void fly() {
        flyable.performFly();
    }

}
