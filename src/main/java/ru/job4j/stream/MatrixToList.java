package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Преобразование матрицы чисел в список чисел.
 * FlatMap
 * @author Shegai Evgenii
 * @version 1.0
 * @since 04.01.2023
 */

public class MatrixToList {

    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
    }
}
