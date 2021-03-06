package ru.job4j.tracker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {

    //Connection init();

    Item add(Item item);

    boolean replace(String id, Item item);

    boolean delete(String id);

    List<Item> findAll();

    List<Item> findByName(String key) throws SQLException;

    Item findById(String id);
}
