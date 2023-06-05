package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullname("Paul Beer");
        student.setGroup("Commercial management");
        student.setReceiptDate("13.08.2021");
        System.out.println("Student info");
        System.out.println("Full Name:\t\t" + student.getFullname());
        System.out.println("Group:\t\t\t" + student.getGroup());
        System.out.println("Receipt Date:\t" + student.getReceiptDate());
    }
}
