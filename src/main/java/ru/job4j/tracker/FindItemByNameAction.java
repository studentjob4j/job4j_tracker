package ru.job4j.tracker;

/**
 * Проект Трекер-  Реализация меню за счет шаблона стратегия
 * @author Shegai Evgeni
 * @version 1.0
 * @since 26.12.2022
 */

public class FindItemByNameAction implements UserAction {

    private final Output out;

    public FindItemByNameAction(Output output) {
        this.out = output;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
