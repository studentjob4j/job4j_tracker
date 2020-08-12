package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        char[]arrayLeft =  left.toCharArray();
        char[]arrayRight = right.toCharArray();
        int result = 0;
        int size = Math.min(arrayLeft.length, arrayRight.length);
        for (int i = 0; i < size; i++) {
            result = Character.compare(arrayLeft[i], arrayRight[i]);
            if (result != 0) {
                return result;

            }
        }
        return arrayLeft.length - arrayRight.length;
    }
}
