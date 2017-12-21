package io.khasang.hotel.model;

public class Main {
    public static void main(String[] args) {
        // for strategy
        Duck duck = new RedHatDuck(new FlyWithWings());
        Duck newDuck = new WoodenDuck(new FlyNoWay());
        newDuck.fly();
    }
}
