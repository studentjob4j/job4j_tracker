package ru.job4j.tracker;

/**
 * @author Evgenii Shegai
 * @since 12.06.2021
 * @version 1.0
 * Для интеграционного тестирования использую liquibase
 */

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
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(tracker.findByName("test1").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenReplace() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item();
            bug.setName("Bug");
            tracker.add(bug);
            int id = bug.getId();
            Item bugWithDesc = new Item();
            bugWithDesc.setName("Bug with description");
            boolean result = tracker.replace(String.valueOf(id), bugWithDesc);
            assertThat(result, is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDelete() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item();
            item.setName("test1");
            item = tracker.add(item);
            boolean result = tracker.delete(String.valueOf(item.getId()));
            assertThat(result, is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whengetAllItems() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            List<Item> result = tracker.findAll();
            assertThat(result.size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindByName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            List<Item> result = tracker.findByName("test1");
            assertThat(result.get(0).getName(), is("test1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindById() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(String.valueOf(tracker.getCount()));
            assertThat(result.getName(), is("test1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}