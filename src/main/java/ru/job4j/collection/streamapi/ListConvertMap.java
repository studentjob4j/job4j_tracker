package ru.job4j.collection.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListConvertMap {

    public Map<String, Student> covert(List<Student> students) {
        return  students.stream()
                .collect(Collectors.toMap(Student::getSurname, s -> s, (a, b) -> a));
    }
}
