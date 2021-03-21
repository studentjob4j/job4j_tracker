package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private final Connection connection;
    private int count;

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    public int getCount() {
        return count;
    }

    public void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String temp = String.format("create table %s (%s, %s);",
                    "items", "id serial primary key", "name text");
            statement.execute(temp);
        }
    }

    @Override
    public Item add(Item item) {
            try (PreparedStatement statement =
                         connection.prepareStatement("insert into items(name) values (?)",
                                 Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, item.getName());
                statement.execute();
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        item.setId(generatedKeys.getInt(1));
                        count = generatedKeys.getInt(1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("update items set name = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, Integer.parseInt(id));
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from items  where id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from items;")) {
             ResultSet resultSet =  statement.executeQuery();
             while (resultSet.next()) {
              Item temp = new Item();
              temp.setName((resultSet.getString("name")));
              temp.setId(resultSet.getInt("id"));
              result.add(temp);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement
                     = connection.prepareStatement("select * from items where name = ?;")) {
            statement.setString(1, key);
            Item temp = new Item();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                temp.setName(resultSet.getString("name"));
                temp.setId(resultSet.getInt("id"));
                result.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = new Item();
        try (PreparedStatement statement
                     = connection.prepareStatement("select * from items where id = ?;")) {
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 result.setName(resultSet.getString("name"));
                 result.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public void drop(String value, Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format("drop table %s", value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
