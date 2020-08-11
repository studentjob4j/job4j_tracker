package ru.job4j.tracker;

import java.util.Comparator;

public class Item implements Comparator<Item> {
    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compare(Item o1, Item o2) {
        return 0;
    }
}