package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 1; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
        out.println(0 + ". " + actions[0].name());
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(),
                new CreateAction(output),
                new FindAllAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}