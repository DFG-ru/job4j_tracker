package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int smAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int y = 15;
        int sum = sum(y);
        int multiply = calculator.multiply(y);
        int minus = minus(y);
        int divide = calculator.divide(y);
        int sumAll = calculator.smAllOperation(y);
        System.out.println(sum);
        System.out.println(multiply);
        System.out.println(minus);
        System.out.println(divide);
        System.out.println(sumAll);
    }
}