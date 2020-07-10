package ru.job4j.tracker;

public class StartUI {

    private final Output out;
    private int count;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        if (count == 0) {
            out.println("Menu.");
            for (int index = 0; index < actions.length; index++) {
                out.println(actions[index].name());
            }
            count++;
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
    }

}
