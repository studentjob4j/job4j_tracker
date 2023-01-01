package ru.job4j.collection;

import java.util.Comparator;

/**
 * Сортировка по приоритету по убыванию
 */

public class SortJobByDescPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getPriority(), o1.getPriority());
    }
}
