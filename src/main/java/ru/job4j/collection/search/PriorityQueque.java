package ru.job4j.collection.search;

import java.util.LinkedList;

public class PriorityQueque {

    private LinkedList<Task> tasks = new LinkedList<>();
    private int i;
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
      /*  if (tasks.size() == 0) {
            tasks.add(0, task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() <= tasks.get(i).getPriority()) {
                    tasks.add(i, task);
                    break;
                }
            }
        }*/

        if (tasks.size() == 0) {
            tasks.add(i, task);
        }
        for (Task temp : tasks) {

            if (task.getPriority() < temp.getPriority()) {
                tasks.add(i, task);
                i++;
                break;
            }

        }


    }

    public Task take() {
        return tasks.poll();
    }

}
