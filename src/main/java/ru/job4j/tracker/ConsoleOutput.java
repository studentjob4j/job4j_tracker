package ru.job4j.tracker;

/**
 * Зависимость от System.out
 * @author Shegai Evgenii
 * @version 1.0
 * @since 27.12.2022
 */

public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
