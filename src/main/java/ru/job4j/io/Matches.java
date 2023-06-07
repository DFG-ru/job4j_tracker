package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            System.out.println("Спичек на столе: " + count);
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= 3 && matches <= count) {
                turn = !turn;
                count -= matches;
            } else {
                System.out.println("Необходимо ввести число от 1 до 3 "
                        + "и не больше остатка (" + count + ")."
                        + System.lineSeparator()
                        + "Ввод не вычитаем, ход не передаем"
                        + System.lineSeparator());
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}