package ru.job4j.tracker;

import org.junit.Test;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return  DriverManager.getConnection(config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        //tracker.createTable();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        assertThat(tracker.findByName("test1").size(), is(1));
        tracker.close();
    }

    @Test
    public void whenReplace() throws  Exception {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        //tracker.createTable();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        boolean result = tracker.replace(String.valueOf(id), bugWithDesc);
        tracker.close();
        assertThat(result, is(true));
    }

    @Test
    public void whenDelete() throws  Exception {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        //tracker.createTable();
        Item item = new Item();
        item.setName("test1");
        item = tracker.add(item);
        boolean result = tracker.delete(String.valueOf(item.getId()));
        tracker.close();
        assertThat(result, is(true));
    }

    @Test
    public void whengetAllItems() throws  Exception {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        //tracker.createTable();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        List<Item> result = tracker.findAll();
        tracker.close();
        assertThat(result.size(), is(1));
    }

    @Test
    public void whenFindByName() throws  Exception {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        //tracker.createTable();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        List<Item> result = tracker.findByName("test1");
        tracker.close();
        assertThat(result.get(0).getName(), is("test1"));
    }

    @Test
    public void whenFindById() throws Exception {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        //tracker.createTable();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(String.valueOf(tracker.getCount()));
        tracker.close();
        assertThat(result.getName(), is("test1"));
    }
}