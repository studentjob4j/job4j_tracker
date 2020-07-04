package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
       int index = indexOf(id);
       return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item result[] = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length ; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                result[size++] = items[i];
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item[] findAll() {
        Item result[] = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length ; i++) {
            if (items[i] != null) {
                result[size++] = items[i];
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.length; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index].setName(item.getName());
        }
        return index != -1 ;
    }
}