package ru.job4j.collection.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = -5; i < 10; i++) {
            list.add(i);
        }
        List<Integer> result = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(result);
    }
}
