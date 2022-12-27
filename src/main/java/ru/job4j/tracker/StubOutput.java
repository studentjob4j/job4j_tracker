package ru.job4j.tracker;

/**
 * Зависимость от System.out
 * @author Shegai Evgenii
 * @version 1.0
 * @since 27.12.2022
 */

public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(Object obj) {
        if (obj != null) {
            buffer.append(obj);
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
