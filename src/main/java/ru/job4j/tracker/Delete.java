package ru.job4j.tracker;

public class Delete  implements  UserAction {
    private final Output out;

    public Delete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " Delete item ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = true;
        int id = input.askInt("Enter id  ");
        if (tracker.delete(id)) {
            out.println("Заявка успешно удалена");
        } else {
            out.println("Введите правильные данные");
        }
         return result;
    }
}
