package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"1", "Item name", "0"}
        );
        UserAction[] actions = {
                new ExitAction(),
                new CreateAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item for edit"));
        Input in = new StubInput(
                new String[]{
                        "1",
                        String.valueOf(item.getId()),
                        "Edited item",
                        "0"
                }
        );
        UserAction[] actions = {
                new ExitAction(),
                new EditAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Edited item");
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Tracker expectedTracker = new Tracker();
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        expectedTracker.add(item1);
        Input in = new StubInput(
                new String[]{"1",
                        String.valueOf(item2.getId()),
                        "0"}
        );
        UserAction[] actions = {
                new ExitAction(),
                new DeleteAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item2.getId())).isNull();
        assertThat(tracker.findAll()).isEqualTo(expectedTracker.findAll());
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0"}
        );
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        );
    }

    @Test
    public void whenFindAll() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Input in = new StubInput(
                new String[]{
                        "1",
                        "0"
                }
        );
        UserAction[] actions = {
                new ExitAction(),
                new FindAllAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "1. Show all items" + ln
                        + "0. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + item1 + ln
                        + item2 + ln
                        + "Menu." + ln
                        + "1. Show all items" + ln
                        + "0. Exit Program" + ln
        );
    }

    @Test
    public void whenFindById() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Input in = new StubInput(
                new String[]{
                        "1",
                        String.valueOf(item2.getId()),
                        "0"
                }
        );
        UserAction[] actions = {
                new ExitAction(),
                new FindByIdAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "1. Find item by id" + ln
                        + "0. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + item2 + ln
                        + "Menu." + ln
                        + "1. Find item by id" + ln
                        + "0. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByName() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Input in = new StubInput(
                new String[]{
                        "1",
                        item2.getName(),
                        "0"
                }
        );
        UserAction[] actions = {
                new ExitAction(),
                new FindByNameAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "1. Find items by name" + ln
                        + "0. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + item2 + ln
                        + "Menu." + ln
                        + "1. Find items by name" + ln
                        + "0. Exit Program" + ln
        );
    }
}
