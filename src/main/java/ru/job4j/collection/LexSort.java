package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int one = 0;
        int two = 0;
        int result = 0;
        for (String temp : left.split("")) {
             one = Integer.parseInt(temp);
            break;
        }
        for (String temp : right.split("\\.")) {
            two = Integer.parseInt(temp);
            result = Integer.compare(one, two);
            break;
        }
        return result;
    }
}
