package ru.job4j.collection;

import java.util.Comparator;
//Компаратор по имени и убыванию

public class WhenCompareByNameAndLess  implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        int result = o2.getName().compareTo(o1.getName());
        return result;
    }
}
