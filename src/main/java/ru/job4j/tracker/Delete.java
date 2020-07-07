package ru.job4j.tracker;

public class Delete  implements  UserAction {

    @Override
    public String name() {
        return " Delete item ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        int id = input.askInt("Enter id  ");
        result = tracker.delete(id);
        return result;

    }
}
