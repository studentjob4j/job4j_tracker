package ru.job4j.collection.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug") && task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);
    }
}

   /* public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = -5; i < 10; i++) {
            list.add(i);
        }
        List<Integer> result = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(result);
    }*/

