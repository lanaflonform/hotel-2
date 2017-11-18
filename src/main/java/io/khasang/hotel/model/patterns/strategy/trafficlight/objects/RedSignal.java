package io.khasang.hotel.model.patterns.strategy.trafficlight.objects;

import io.khasang.hotel.model.patterns.strategy.trafficlight.behavior.ConstantLightBehavior;

public class RedSignal extends Signal {

    public RedSignal(int time) {
        lightBehavior = new ConstantLightBehavior();
        color = Signals.RED;
        this.time = time;
    }
}
