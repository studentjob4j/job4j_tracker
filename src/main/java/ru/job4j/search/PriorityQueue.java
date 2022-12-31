package ru.job4j.search;

/**
 *  Очередь с приоритетом на LinkedList
 *  * @author Shegai Evgeni
 *  * @version 1.0
 *  * @since 31.12.2022
 */

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
