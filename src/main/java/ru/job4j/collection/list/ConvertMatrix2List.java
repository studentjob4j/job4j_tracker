package ru.job4j.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] temp : array) {
            for (int value : temp) {
                list.add(value);
            }
        }
        return list;
    }
}
