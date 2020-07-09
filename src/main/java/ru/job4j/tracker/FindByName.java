package ru.job4j.tracker;

public class FindByName implements UserAction  {

    @Override
    public String name() {
        return "Find by name ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = true;
        String key = input.askStr("Enter name  ");
        Item[] temp = tracker.findByName(key);
        if (temp.length >= 0) {
            for (int i = 0; i < temp.length; i++) {
                System.out.println("Вывод заявок с таким именем " + temp[i].getName() + "  и с таким id " + temp[i].getId());
            }
        } else {
            System.out.println("Заявок с таким именем нет");
        }

        return result;
    }
}
