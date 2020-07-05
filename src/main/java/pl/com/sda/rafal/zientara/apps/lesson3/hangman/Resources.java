package pl.com.sda.rafal.zientara.apps.lesson3.hangman;

import java.util.*;

public class Resources {

    public static final List<String> DATA = Arrays.asList(
            "Ala ma kota",
            "Kot ma Ale",
            "Programowanie JAVA",
            "Test Driven Development",
            "Klasy generyczne",
            "Klasa abstrakcyjna",
            "Software Development Academy",
            "Java Development Kit",
            "Lubie programowac",
            "Jaki piekny kod",
            "Funkcja rekurencyjna",
            "spaghetti code",
            "Kompilator",
            "SOLID",
            "system kontroli wersji GIT",
            "Kompozycja",
            "Polimorfizm",
            "Dziedziczenie",
            "Wyjatki",
            "Typy generyczne",
            "Lambda",
            "Debugowanie",
            "JavaFX",
            "Stream",
            "zlozonosc obliczeniowa",
            "Kolejki",
            "Kopce",
            "Drzewa",
            "Graf",
            "quicksort",
            "bubble sort",
            "Garbage collector",
            "mockowanie",
            "Singleton",
            "Builder",
            "Wzorce projektowe",
            "Baza danych"
    );

    public static String getRandomPuzzle() {
        int bound = DATA.size();
        int randomIndex = new Random().nextInt(bound);
        return DATA.get(randomIndex);
    }

    public static void main(String[] args) {

        Collections.sort(DATA, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareToIgnoreCase(t1);
            }
        });

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int number = random.nextInt(10);// %10
            System.out.println(number);
        }

        System.out.println(getRandomPuzzle());
    }

}
