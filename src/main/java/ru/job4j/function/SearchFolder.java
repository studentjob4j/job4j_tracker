package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Встроенные функциональные интерфейсы
 * @author Shegai Evgenii
 * @version 1.0
 * @since 01.01.2023
 */

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> result = new ArrayList<>();
        for (Folder value : list) {
            if (pred.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
