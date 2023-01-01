package ru.job4j.collection;

import java.util.Comparator;

/**
 * Компаратор для строк
 * @author Shegai Evgenii
 * @version 1.0
 * @since 01.01.2023
 */

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int size = Math.min(o1.length(), o2.length());
        for (int i = 0; i < size; i++) {
            result = Character.compare(o1.charAt(i), o2.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
