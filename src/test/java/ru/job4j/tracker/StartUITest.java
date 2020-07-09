package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1", "1", "New item ", "2"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is("New item "));
    }

    @Test
    public void whenFindByItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "2", "1", "3"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(), new FindById(), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        Item result = tracker.findById(1);
        assertThat(result.getName(), is("Item name"));
    }

    @Test
    public void whenFindByName() {
        Input in = new StubInput(new String[] {"0", "Item name", "3", "Item name", "4"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(), new FindById(),new FindByName(), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        Item[] result = tracker.findByName("Item name");
        assertThat(result[0].getName(), is("Item name"));
    }

    @Test
    public void whenFindAll() {
        Input in = new StubInput(new String[] {"0", "Item name", "4", "5"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(), new FindById(),new FindByName(), new FindAll(),
                new Exit()};
        new StartUI(out).init(in, tracker, actions);
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is("Item name"));
    }

    @Test
    public void whenDelete() {
        Input in = new StubInput(new String[] {"0", "Item name", "6" ,"1", "6"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(), new FindById(),new FindByName(), new FindAll(),
                new Delete(), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        boolean result = tracker.delete(1);
        assertThat(result, is(true));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0.  Exit " + System.lineSeparator()));
    }
}