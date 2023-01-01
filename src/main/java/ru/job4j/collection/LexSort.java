package ru.job4j.collection;

import java.util.Comparator;

/**
 * Сортировка номера
 * @author Shegai Evgenii
 * @version 1.0
 * @since 01.01.2023
 */

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] one = o1.split("\\.");
        String[] two = o2.split("\\.");
        return Integer.compare(Integer.parseInt(one[0]), Integer.parseInt(two[0]));
    }
}
