package ru.job4j.tracker;

public class Replace  implements UserAction {

    @Override
    public String name() {
        return " Replace item ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        int id = input.askInt("Enter id  ");
        Item temp = new Item();
        temp.setName(input.askStr(" Enter new item name "));
        result = tracker.replace(id, temp);
        return result;

    }
}
