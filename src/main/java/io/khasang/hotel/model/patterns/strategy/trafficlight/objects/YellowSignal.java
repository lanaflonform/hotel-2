package io.khasang.hotel.model.patterns.strategy.trafficlight.objects;

import io.khasang.hotel.model.patterns.strategy.trafficlight.behavior.ConstantLightBehavior;

public class YellowSignal extends Signal {

    public YellowSignal(int time) {
        lightBehavior = new ConstantLightBehavior();
        color = Signals.YELLOW;
        this.time = time;
    }
}
