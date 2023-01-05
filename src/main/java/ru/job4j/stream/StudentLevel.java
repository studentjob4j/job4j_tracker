package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Stream API
 * улучшения
 * @author Shegai Evgenii
 * @version 1.0
 * @since 06.01.2023
 */

public class StudentLevel {

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScore(),  left.getScore()))
                .takeWhile(st -> true)
                .collect(Collectors.toList());
    }
}
