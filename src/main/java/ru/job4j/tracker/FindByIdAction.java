package ru.job4j.tracker;

/**
 * Проект Трекер-  Реализация меню за счет шаблона стратегия
 * @author Shegai Evgeni
 * @version 1.0
 * @since 26.12.2022
 */

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output output) {
        this.out = output;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
