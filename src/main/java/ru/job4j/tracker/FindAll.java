package ru.job4j.tracker;

public class FindAll implements UserAction {

    @Override
    public String name() {
        return "Find all ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        Item[] temp = tracker.findAll();
        if (temp.length > 0) {
            result = true;
        }
        return result;
    }
}
