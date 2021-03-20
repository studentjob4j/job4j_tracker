package ru.job4j.tracker;

public class CreateAction  implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new Item ";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        Item item = new Item();
        item.setName(input.askStr("Enter items name "));
        tracker.add(item);
        return true;
    }
}
