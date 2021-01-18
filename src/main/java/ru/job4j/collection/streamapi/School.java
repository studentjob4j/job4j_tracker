package ru.job4j.collection.streamapi;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
       List<Student> result = students.stream()
               .filter(x -> predict.test(x))
               .collect(Collectors.toUnmodifiableList());
       return result;
    }
}
