package ru.job4j.tracker;

/**
 * Проект Трекер
 * @author Shegai Evgeni
 * @version 1.0
 * @since 26.12.2022
 */
public class StartUI {

    private final Output out;

    public StartUI(Output output) {
        this.out = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = (input.askInt("Select "));
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            out.println(actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] userAction = {new CreateAction(output), new DeleteAction(output),
        new EditAction(output), new FindByIdAction(output), new FindItemByNameAction(output), new ShawAllAction(output),
                new ExitAction(output)};
        new StartUI(output).init(input, tracker, userAction);
    }
}