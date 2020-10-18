package pl.com.sda.rafal.zientara.apps.lesson2.hangman;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        int randomIndex = new Random().nextInt(DATA.size());
        return DATA.get(randomIndex);
    }

}
