package ru.job4j.tracker;

public class FindByName implements UserAction  {

    @Override
    public String name() {
        return "Find by name ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        String key = input.askStr("Enter name  ");
        Item[] temp = tracker.findByName(key);
        if (temp.length >= 0) {
            result = true;
        }
        return result;
    }
}
