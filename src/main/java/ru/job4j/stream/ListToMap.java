package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * List -> Map
 * @author Shegai Evgenii
 * @version 1.0
 * @since 04.01.2023
 */

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors
                        .toMap(x -> x.getSurname(), x -> x, (existing, replacment) -> existing));
    }
}
