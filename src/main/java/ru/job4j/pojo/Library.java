package ru.job4j.pojo;

public class Library {
    public static void swapBooks(Book[] books, int sTarget, int fTarget) {
        Book buf = books[sTarget];
        books[sTarget] = books[fTarget];
        books[fTarget] = buf;
    }

    public static void main(String[] args) {
        Book b1984 = new Book("1984", "Джордж Оруэлл");
        Book annaKarenina = new Book("Анна Каренина", "Лев Толстой");
        Book masterAndMargarita = new Book("Мастер и Маргарита", "Михаил Булгаков");
        Book cleanCode = new Book("Clean Code", "Unknown");
        Book smileOfJoker = new Book("Улыбка джокера", "Джокер");
        Book[] books = {b1984, annaKarenina, masterAndMargarita, cleanCode, smileOfJoker};
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + ": " + books[i].getName() + " - " + books[i].getAuthor());
        }
        System.out.println("\nSwap 0 and 3");
        swapBooks(books, 0, 3);
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + ": " + books[i].getName() + " - " + books[i].getAuthor());
        }
        System.out.println("\nSearch book: \"Clean Code\"");
        for (Book book : books) {
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + " - " + book.getAuthor());
            }
        }
    }
}