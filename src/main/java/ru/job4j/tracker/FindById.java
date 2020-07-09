package ru.job4j.tracker;

public class FindById  implements UserAction {
    private final Output out;

    public FindById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = true;
        int id = input.askInt("Enter id  ");
        Item temp = tracker.findById(id);
        if (temp != null) {
            System.out.println("Заявка наидена " + temp.getName() + " " + temp.getId());
        } else {
            System.out.println("Заявка не найдена");
        }
        return result;
    }
}
