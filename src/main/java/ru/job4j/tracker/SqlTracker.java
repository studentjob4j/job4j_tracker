package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"),
                    config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void createTable( SqlTracker tracker) throws SQLException {
        try (Statement statement = tracker.connection.createStatement()) {
            String temp = String.format("create table %s (%s, %s, %s);", "items", "id serial primary key", "item_id int", "name text");
            statement.execute(temp);
        }
    }

    @Override
    public Item add(Item item) {
            try (PreparedStatement statement = connection.prepareStatement("insert into items(item_id,name) values (? , ?)",
                                 Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(2, item.getName());
                statement.setInt(1, -1);
                statement.execute();
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        item.setId(generatedKeys.getInt(1));
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
                     connection.prepareStatement("update items set item_id = ?, name = ? where id = ?")) {
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setInt(3, Integer.parseInt(id));
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
              temp.setId(resultSet.getInt("item_id"));
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
        try (PreparedStatement statement = connection.prepareStatement("select * from items where name = ?;")) {
            statement.setString(1, key);
            Item temp = new Item();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                temp.setName(resultSet.getString("name"));
                temp.setId(resultSet.getInt("item_id"));
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
        try (PreparedStatement statement = connection.prepareStatement("select * from items where id = ?;")) {
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                 result.setName(resultSet.getString("name"));
                 result.setId(resultSet.getInt("item_id"));
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

    public void execute(String value) {
        try (Statement statement = this.connection.createStatement()) {
            statement.execute(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drop(String name) {
        String temp = String.format("drop table %s;", name);
        execute(temp);
    }

}
