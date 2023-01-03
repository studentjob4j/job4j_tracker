package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Фильтрация учеников
 * @author Shegai Evgenii
 * @version 1.0
 * @since 04.01.2023
 */

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
       return students.stream().filter(predict).collect(Collectors.toList());
    }

}
