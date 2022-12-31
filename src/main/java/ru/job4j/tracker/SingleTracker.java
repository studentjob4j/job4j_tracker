package ru.job4j.tracker;

import java.util.List;

/**
 *  Singleton
 * @author Shegai Evgenii
 * @version 1.0
 */

public final class SingleTracker {

    private static SingleTracker singleTracker = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
       return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
       return tracker.replace(id, item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
      return findByName(key);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
