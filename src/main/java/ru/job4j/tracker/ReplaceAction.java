package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Replace item ===");
        String name = input.askStr("Enter name: ");
        int id = input.askInt("Enter id to replace: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Заявка заменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}