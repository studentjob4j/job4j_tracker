package ru.job4j.tracker;

public class FindAll implements UserAction {

    @Override
    public String name() {
        return "Find all ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = true;
        Item[] temp = tracker.findAll();
        if (temp.length > 0) {
            for (int i = 0; i < temp.length ; i++) {
                System.out.println(temp[i].getName() + " " +  temp[i].getId());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены ");
        }
        return result;
    }
}
