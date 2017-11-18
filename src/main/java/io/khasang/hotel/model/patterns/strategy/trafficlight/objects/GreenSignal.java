package io.khasang.hotel.model.patterns.strategy.trafficlight.objects;

import io.khasang.hotel.model.patterns.strategy.trafficlight.behavior.ConstantLightBehavior;

public class GreenSignal extends Signal {

    public GreenSignal(int time) {
        lightBehavior = new ConstantLightBehavior();
        color = Signals.GREEN;
        this.time = time;
    }
}
