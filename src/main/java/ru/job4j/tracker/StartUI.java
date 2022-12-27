package ru.job4j.tracker;

/**
 * Проект Трекер
 * @author Shegai Evgeni
 * @version 1.0
 * @since 26.12.2022
 */
public class StartUI {

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
        System.out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] userAction = {new CreateAction(), new DeleteAction(),
        new EditAction(), new FindByIdAction(), new FindItemByNameAction(), new ShawAllAction(),
                new ExitAction()};
        new StartUI().init(input, tracker, userAction);
    }
}