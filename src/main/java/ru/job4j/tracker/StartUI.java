package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 1; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
        System.out.println(0 + ". " + actions[0].name());
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(),
                new CreateAction(),
                new ShowAllAction(),
                new EditAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}