package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Input in = new StubInput(
                new String[]{"0", "1", "Edited item", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new EditAction(),
                new ExitAction()
        };
        Item item = new Item("Item for edit");
        tracker.add(item);
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Edited item");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "Replaced item", "1", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        Item item = new Item("Item to replace");
        tracker.add(item);
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Replaced item");
    }

    @Test
    public void whenDeleteItem() {
        Input in = new StubInput(
                new String[]{"0", "2", "1"}
        );
        Tracker tracker = new Tracker();
        Tracker expectedTracker = new Tracker();
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        expectedTracker.add(item1);
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item2.getId())).isNull();
        assertThat(tracker.findAll()).isEqualTo(expectedTracker.findAll());
    }
}