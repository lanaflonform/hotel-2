package io.khasang.hotel.model.patterns.strategy.trafficlight.behavior;

public class ConstantLightBehavior implements LightBehavior {
    @Override
    public void light(int time) {
        System.out.println("Постоянный свет");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
