package pl.com.sda.rafal.zientara.apps.homework.zbior2;

import pl.com.sda.rafal.zientara.apps.lesson2.hangman.Hangman;
import pl.com.sda.rafal.zientara.apps.lesson3.hangman.Resources;

import java.util.Scanner;

//zad 1
public class HangmanConsoleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hangman hangman = new Hangman();
        hangman.setPuzzle(Resources.getRandomPuzzle());

        while (!hangman.isGameOver()) {
            System.out.println("Aktualne hasło:"+hangman.getOutput());
            System.out.printf("HP %d/7\n",hangman.getHp());
            System.out.printf("Wprowadzone litery:%s\n",hangman.getTries());
            System.out.println("Podaj literę lub podaj całą odpowiedź");
            String s = scanner.nextLine();
            hangman.guess(s);
        }

        if (hangman.isWin()) {
            System.out.println("Gratulacje wygrałeś!");
        } else {
            System.out.println("Przegrałeś :(");
        }
    }
}
