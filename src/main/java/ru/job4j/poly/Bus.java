package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Машина едет");
    }

    @Override
    public void passengers(int peoples) {
        System.out.println("Пассажиров: " + peoples);
    }

    @Override
    public int refuel(int fuelCount) {
        int pricePerLiter = 50;
        return pricePerLiter * fuelCount;
    }
}
