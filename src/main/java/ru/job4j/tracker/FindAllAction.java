package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            out.println("Хранилище ещё не содержит заявок");
        } else {
            for (Item item : items) {
                out.println(item);
            }
        }
        return true;
    }
}
