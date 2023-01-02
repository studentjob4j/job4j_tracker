package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Подсчет функции в диапазоне
 * @author Shegai Evgenii
 * @version 1.0
 * @since 02.01.2023
 */

public class FunctionalCalculator {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }
}
