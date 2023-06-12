package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Хранилище ещё не содержит заявок");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
        return true;
    }
}
