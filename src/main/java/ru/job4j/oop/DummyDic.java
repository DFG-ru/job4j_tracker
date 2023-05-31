package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Низвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic translate = new DummyDic();
        System.out.println(translate.engToRus("Supercalifragilisticexpialidocious"));
    }
}
