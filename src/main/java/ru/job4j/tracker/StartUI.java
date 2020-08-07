package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Output out;
    private int count;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                run = false;
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        if (count == 0) {
            out.println("Menu.");
            for (int index = 0; index < actions.size(); index++) {
                out.println(actions.get(index).name());
            }
            count++;
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new Replace(output));
        actions.add(new FindAll(output));
        actions.add(new Delete(output));
        actions.add(new FindByName(output));
        actions.add(new FindById(output));
        actions.add(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
    }

}
