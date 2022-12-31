package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Проект Трекер
 * @author Shegai Evgeni
 * @version 1.0
 * @since 17.12.2022
 */
public class Tracker {
    private List<Item> list = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        list.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
               rsl = i;
               break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int rsl = indexOf(id);
        return rsl != -1 ? list.get(rsl) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            list.add(index, item);
        }
        return index != -1;
    }

    public List<Item> findAll() {

        return List.copyOf(list);
    }

    public List<Item> findByName(String key) {
       List<Item> result = new ArrayList<>();
        for (Item item : list) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            list.remove(index);
        }
        return index != -1;
    }
}