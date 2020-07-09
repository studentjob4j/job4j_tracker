package ru.job4j.tracker;

public class Delete  implements  UserAction {

    @Override
    public String name() {
        return " Delete item ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = true;
        int id = input.askInt("Enter id  ");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена");
        } else {
            System.out.println("Введите правильные данные");
        }
         return result;
    }
}
