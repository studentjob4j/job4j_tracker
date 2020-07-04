package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("One");
        Item result = tracker.add(item);
        System.out.println(result.getId());
        result = tracker.findById(1);
        System.out.println(result.getName());
    }
}
