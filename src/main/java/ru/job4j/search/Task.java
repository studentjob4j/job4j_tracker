package ru.job4j.search;

/**
 *  Очередь с приоритетом на LinkedList
 *  * @author Shegai Evgeni
 *  * @version 1.0
 *  * @since 31.12.2022
 */

public class Task {

    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
