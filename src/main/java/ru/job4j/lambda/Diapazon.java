package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapazon {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        do {
            list.add(func.apply((double) start));
            start++;
        } while (start < end);
            return list;
    }

}
