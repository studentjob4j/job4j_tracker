package ru.job4j.collection;

import java.util.Comparator;
//По приоритету и убыванию

public class WhenCompareByPrioritetAndLess  implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        int temp = o1.getPriority();
        int temp2 = o2.getPriority();
        int result = temp2 - temp;
        return result;
    }
}
