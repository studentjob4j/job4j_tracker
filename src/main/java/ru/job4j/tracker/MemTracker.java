
package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker {
    private final List<Item> list = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        list.add(item);
        return item;
    }

    public Item findById(int id) {
       int index = indexOf(id);
       return index != -1 ? list.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(key)) {
                result.add(list.get(i));
            }
        }
        return result;

    }

    public List<Item> findAll() {
        return this.list;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            list.set(index, item);
        }
        return index != -1;
    }

    public boolean delete(int id) {
        boolean result = false;
        int temp = indexOf(id);
        if (temp != -1) {
           list.remove(temp);
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        while (true) {
            Output output = new ConsoleOutput();
            ArrayList<String> list = new ArrayList<>(10000000);
            for (int i = 0; i < 9999998; i++) {
                list.add("0");
            }
            list.add(999998, "1");
            Input in = new StubInput(list);
            MemTracker tracker = new MemTracker();
            ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(output));
            actions.add(new Exit(output));
            new StartUI(output).init(in, tracker, actions);
        }
    }
}
