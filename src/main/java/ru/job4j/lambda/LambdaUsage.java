package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Лямбда блок
 * @author Shegai Evgenii
 * @version 1.0
 * @since 02.01.2023
 */

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a",  "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> Integer.compare(right.length(), left.length());
        strings.sort(comparator);
        System.out.println("Лист после сортировки от большей длинны к меньшей длине строки " + strings);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
