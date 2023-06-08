package ru.job4j.cast;

public class MainVehicle {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();
        bus.move();
        train.move();
        airplane.move();
    }
}
