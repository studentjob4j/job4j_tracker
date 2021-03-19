package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Before
    public void whenDropTable() {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.drop("items");
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.createTable(tracker);
        Item item = new Item();
        item.setName("test1");
        Item result = tracker.add(item);
        tracker.close();
        assertThat(result.getId(), is(1));
    }

    @Test
    public void whenReplace() throws  Exception {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.createTable(tracker);
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
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.createTable(tracker);
        Item item = new Item();
        item.setName("test1");
        item = tracker.add(item);
        boolean result = tracker.delete(String.valueOf(item.getId()));
        tracker.close();
        assertThat(result, is(true));
    }

    @Test
    public void whengetAllItems() throws  Exception {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.createTable(tracker);
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        List<Item> result = tracker.findAll();
        tracker.close();
        assertThat(result.size(), is(1));
    }

    @Test
    public void whenFindByName() throws  Exception {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.createTable(tracker);
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        List<Item> result = tracker.findByName("test1");
        tracker.close();
        assertThat(result.get(0).getName(), is("test1"));
    }

    @Test
    public void whenFindById() throws Exception {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.createTable(tracker);
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(String.valueOf(1));
        tracker.close();
        assertThat(result.getName(), is("test1"));
    }

}