package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item " + System.lineSeparator() + "Exit " + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItem() {
        Input in = new StubInput(new String[]{"0", "Item name", "1", "1", "New item ", "2"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(out), new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item " + System.lineSeparator() +
                "Replace item " + System.lineSeparator() + "Exit " + System.lineSeparator() + "Заявка успешно изменена" + System.lineSeparator()));
    }

    @Test
    public void whenFindByItem() {
        Input in = new StubInput(new String[]{"0", "Item name", "2", "1", "3"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(out), new FindById(out), new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item " + System.lineSeparator() + "Replace item " + System.lineSeparator() + "Find by id " + System.lineSeparator() +
                "Exit " + System.lineSeparator() +
                "Заявка наидена Item name 1" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Input in = new StubInput(new String[]{"0", "Item name", "3", "Item name", "4"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(out), new FindById(out), new FindByName(out), new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item " + System.lineSeparator() + "Replace item " + System.lineSeparator() + "Find by id " + System.lineSeparator() +
                "Find by name " + System.lineSeparator() +
                "Exit " + System.lineSeparator() +
                "Вывод заявок с таким именем Item name  и с таким id 1" + System.lineSeparator()));
    }

    @Test
    public void whenFindAll() {
        Input in = new StubInput(new String[]{"0", "Item name", "4", "5"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(out), new FindById(out), new FindByName(out), new FindAll(out),
                new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item " + System.lineSeparator() + "Replace item " + System.lineSeparator() + "Find by id " + System.lineSeparator() +
                "Find by name " + System.lineSeparator() + "Find all " + System.lineSeparator() + "Exit " + System.lineSeparator() +
                "Item name 1" + System.lineSeparator()));
    }

    @Test
    public void whenDelete() {
        Input in = new StubInput(new String[]{"0", "Item name", "6", "1", "6"});
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {new CreateAction(out), new Replace(out), new FindById(out), new FindByName(out), new FindAll(out),
                new Delete(out), new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        boolean result = tracker.delete(1);
        assertThat(result, is(true));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Exit " + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format("Menu.%n"
                                + "Exit %n"
                                + "Wrong input, you can select: 0 .. 0%n"
                )
        ));
    }

    @Test
    public void whenValidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format("Menu.%n"
                                + "Exit %n"
                )
        ));
    }

}