package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace item ===");
        String name = input.askStr("Enter name: ");
        int id = input.askInt("Enter id to replace: ");
        if (tracker.replace(id, new Item(name))) {
            out.println("Заявка заменена успешно.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}