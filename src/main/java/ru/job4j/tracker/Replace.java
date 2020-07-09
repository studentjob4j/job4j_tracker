package ru.job4j.tracker;

public class Replace  implements UserAction {
    private final Output out;

    public Replace(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " Replace item ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = true;
        int id = Integer.parseInt(input.askStr("Enter id  "));
        Item temp = new Item();
        temp.setName(input.askStr(" Enter new item name "));
        if (tracker.replace(id,temp)) {
            System.out.println("Заявка успешно изменена");
        } else {
            System.out.println("Введите правильные данные");
        }
        return result;
    }
}
