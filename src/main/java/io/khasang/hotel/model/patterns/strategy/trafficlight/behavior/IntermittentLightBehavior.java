package io.khasang.hotel.model.patterns.strategy.trafficlight.behavior;

public class IntermittentLightBehavior implements LightBehavior {
    @Override
    public void light(int time) {
        System.out.println("Прерывистый сигнал");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
