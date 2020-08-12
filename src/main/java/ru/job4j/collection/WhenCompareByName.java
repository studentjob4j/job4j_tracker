package ru.job4j.collection;

import java.util.Comparator;
//По имени и возрастанию

public class WhenCompareByName  implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        int result = o1.getName().compareTo(o2.getName());
        return result;
    }
}
