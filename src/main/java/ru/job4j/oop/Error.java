package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active = " + this.active);
        System.out.println("Status = " + this.status);
        System.out.println("Message = " + this.message);
    }

    public static void main(String[] args) {
        Error errorOne = new Error();
        Error errorTwo = new Error(false, 0, "All fine");
        errorOne.printInfo();
        errorTwo.printInfo();
    }
}