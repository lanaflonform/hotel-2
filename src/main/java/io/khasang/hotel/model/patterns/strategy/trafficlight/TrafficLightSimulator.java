package io.khasang.hotel.model.patterns.strategy.trafficlight;

import io.khasang.hotel.model.patterns.strategy.trafficlight.objects.GreenSignal;
import io.khasang.hotel.model.patterns.strategy.trafficlight.objects.RedSignal;
import io.khasang.hotel.model.patterns.strategy.trafficlight.objects.Signal;
import io.khasang.hotel.model.patterns.strategy.trafficlight.objects.YellowSignal;
import io.khasang.hotel.model.patterns.strategy.trafficlight.ui.ConsoleUserInput;
import io.khasang.hotel.model.patterns.strategy.trafficlight.ui.UI;

import java.util.ArrayList;
import java.util.List;

public class TrafficLightSimulator {
    private UI userInput;

    public static void main(String[] args) {
        TrafficLightSimulator simulator = new TrafficLightSimulator();
        simulator.go();
    }

    private void go() {
        initUI();

        List<Signal> signals = new ArrayList<Signal>();
        signals.add(new RedSignal(userInput.getUserInput()));
        signals.add(new YellowSignal(userInput.getUserInput()));
        signals.add(new GreenSignal(userInput.getUserInput()));

        for (Signal signal : signals) {
            signal.describe();
            signal.showLight();
        }
    }

    private void initUI() {
        userInput = new ConsoleUserInput();
    }
}
