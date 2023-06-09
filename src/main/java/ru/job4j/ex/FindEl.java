package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Элемент в массиве не найден");
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] strArr = new String[]{"bob", "bib", "beb"};
        try {
            System.out.println(indexOf(strArr, "bibe"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}