package ru.job4j.tracker;

import java.util.List;

public class FindAll implements UserAction {
    private final Output out;

    public FindAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all ";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        boolean result = true;
        List<Item> temp = tracker.findAll();
        if (temp.size() > 0) {
            for (int i = 0; i < temp.size(); i++) {
                out.println(temp.get(i).getName());
            }
        } else {
            out.println("Заявки с таким именем не найдены ");
        }
        return result;
    }
}
