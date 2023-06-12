package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction action = new CreateAction();
        action.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        UserAction action = new EditAction();
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "edited item"
        };
        action.execute(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName()).isEqualTo("edited item");
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Tracker expectedTracker = new Tracker();
        UserAction action = new DeleteAction();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        expectedTracker.add(item1);
        String[] answers = {
                String.valueOf(item2.getId())
        };
        action.execute(new StubInput(answers), tracker);
        assertThat(tracker.findById(item2.getId())).isNull();
        assertThat(tracker.findAll()).isEqualTo(expectedTracker.findAll());
    }
}