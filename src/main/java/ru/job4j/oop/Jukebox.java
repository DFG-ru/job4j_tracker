package ru.job4j.oop;

public class Jukebox {
    public String music(int position) {
        return switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        for (int i = 0; i < 5; i++) {
            System.out.println(jukebox.music(i));
        }
    }
}
