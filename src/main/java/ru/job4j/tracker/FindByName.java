package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class FindByName implements UserAction  {
    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name ";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        boolean result = true;
        String key = input.askStr("Enter name  ");
        List<Item> temp = tracker.findByName(key);
        if (temp.size() >= 0) {
            for (int i = 0; i < temp.size(); i++) {
                out.println("Вывод заявок с таким именем " + temp.get(i).getName());
            }
        } else {
            out.println("Заявок с таким именем нет");
        }
        return result;
    }
}
