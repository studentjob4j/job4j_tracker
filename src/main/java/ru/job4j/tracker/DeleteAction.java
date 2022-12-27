package ru.job4j.tracker;

/**
 * Проект Трекер-  Реализация меню за счет шаблона стратегия
 * @author Shegai Evgeni
 * @version 1.0
 * @since 26.12.2022
 */

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output output) {
        this.out = output;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
