package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "Edited item", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        Item item = new Item("Item for edit");
        tracker.add(item);
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Edited item");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "Replaced item", "1", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
        Item item = new Item("Item to replace");
        tracker.add(item);
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Replaced item");
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "2", "1"}
        );
        Tracker tracker = new Tracker();
        Tracker expectedTracker = new Tracker();
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        expectedTracker.add(item1);
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item2.getId())).isNull();
        assertThat(tracker.findAll()).isEqualTo(expectedTracker.findAll());
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        );
    }
}