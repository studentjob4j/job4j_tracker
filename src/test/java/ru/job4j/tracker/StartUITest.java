package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("Item name");
        list.add("1");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item "
                + System.lineSeparator() + "Exit " + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItem() {
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("Item name");
        list.add("1");
        list.add("0");
        list.add("New item ");
        list.add("2");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Replace(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item "
                + System.lineSeparator() + "Replace item " + System.lineSeparator() + "Exit "
                + System.lineSeparator() + "Заявка успешно изменена" + System.lineSeparator()));
    }

    @Test
    public void whenFindByItem() {
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("Item name");
        list.add("2");
        list.add("0");
        list.add("3");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Replace(out));
        actions.add(new FindById(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item "
                + System.lineSeparator() + "Replace item " + System.lineSeparator()
                + "Find by id " + System.lineSeparator() + "Exit " + System.lineSeparator()
                + "Заявка наидена Item name" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("Item name");
        list.add("3");
        list.add("Item name");
        list.add("4");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Replace(out));
        actions.add(new FindById(out));
        actions.add(new FindByName(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item "
                + System.lineSeparator() + "Replace item " + System.lineSeparator() + "Find by id "
                + System.lineSeparator() + "Find by name " + System.lineSeparator() + "Exit "
                + System.lineSeparator() + "Вывод заявок с таким именем Item name"
                + System.lineSeparator()));
    }

    @Test
    public void whenFindAll() {
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("Item name");
        list.add("4");
        list.add("5");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Replace(out));
        actions.add(new FindById(out));
        actions.add(new FindByName(out));
        actions.add(new FindAll(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item "
                + System.lineSeparator() + "Replace item " + System.lineSeparator() + "Find by id "
                + System.lineSeparator() + "Find by name " + System.lineSeparator() + "Find all "
                + System.lineSeparator() + "Exit " + System.lineSeparator()
                + "Item name" + System.lineSeparator()));
    }

    @Test
    public void whenDelete() {
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("Item name");
        list.add("5");
        list.add("0");
        list.add("6");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Replace(out));
        actions.add(new FindById(out));
        actions.add(new FindByName(out));
        actions.add(new FindAll(out));
        actions.add(new Delete(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Create a new Item "
                + System.lineSeparator() + "Replace item " + System.lineSeparator() + "Find by id "
                + System.lineSeparator() + "Find by name " + System.lineSeparator() + "Find all "
                + System.lineSeparator() + "Delete item " + System.lineSeparator()
                + "Exit " + System.lineSeparator()
                + "Заявка успешно удалена" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "Exit "
                + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format("Menu.%n" + "Exit %n" + "Wrong input, you can select: 0 .. 0%n")));
    }

    @Test
    public void whenValidExit() {
        Output out = new StubOutput();
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        Input in = new StubInput(list);
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format("Menu.%n" + "Exit %n")));
    }

}