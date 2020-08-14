package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] one = new String[left.length()];
        String[] two = new String[right.length()];
        int result = 0;
        int i = 0;
        for (String temp : left.split("\\.")) {
            one[i++] = temp;
        }
        i = 0;
        for (String temp : right.split("\\.")) {
            two[i++] = temp;
        }
        for (int j = 0; j < 1; j++) {
            int temp = Integer.parseInt(one[j]);
            int temp2 = Integer.parseInt(two[j]);
            result = temp - temp2;
        }
        return result;
    }
}