package io.khasang.hotel.model.patterns.strategy.trafficlight.behavior;

public interface LightBehavior {
    /**
     * method for light signal
     *
     * @param time - time of lighting
     */
    void light(int time);
}
