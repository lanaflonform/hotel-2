package io.khasang.hotel.model.patterns.strategy.trafficlight.ui;

import java.util.Scanner;

public class ConsoleUserInput implements UI {
    private Scanner scanner;

    public ConsoleUserInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int getUserInput() {
        Integer time;
        System.out.println("Input time");
        time = scanner.nextInt();
        return time;
    }
}
