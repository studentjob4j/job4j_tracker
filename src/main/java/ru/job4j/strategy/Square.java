package ru.job4j.strategy;

/**
 * Strategy pattern
 * @author Shegai Evgeni
 * @version 1.0
 * @since 17.12.2022
 */

public class Square implements Shape {
    @Override
    public String draw() {
          String ln = System.lineSeparator();
          return " --- " + ln + "|  |" + ln + " --- ";
    }
}
