package ru.job4j.collection.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixConvertList {

    public List<Integer> list(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
    }
}
