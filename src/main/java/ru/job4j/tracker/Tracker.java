package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 0;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int size = 0;
        Item[] itemsName = new Item[this.size];
        for (int i = 0; i < this.size; i++) {
            if (items[i].getName().equals(key)) {
                itemsName[size++] = items[i];
            }
        }
        return Arrays.copyOf(itemsName, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                return index;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items[index] = item;
        return true;
    }

    public boolean delete(int id) {
        if (id == -1 || id >= items.length) {
            return false;
        }
        items[id] = null;
        size--;
        return true;
    }
}