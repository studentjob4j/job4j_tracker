package ru.job4j.tracker;

import java.util.Comparator;

public class OneLessThenTwo implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        int result = 0;
        if (o1.getId() > o2.getId()) {
            result = 1;
        } else if (o1.getId() < o2.getId()) {
            result = -1;
        }
        return  result;
    }
}
