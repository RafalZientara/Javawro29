package pl.com.sda.rafal.zientara.apps.lesson3.Hangman;

import pl.com.sda.rafal.zientara.apps.lesson2.hangman.Hangman;

import java.util.Scanner;
import java.util.Set;

public class HangmanConsole {
    Hangman game = new Hangman();

    public HangmanConsole() {
        game.setPuzzle(Resources.getRandomPuzzle());
        refreshConsole();
    }

    private void refreshConsole() {
        refreshPuzzle();
        refreshHp();
        refreshTries();
    }

    private void refreshPuzzle() {
        String output = game.getOutput();
        System.out.println("HASŁO: " + output);
    }

    private void refreshHp() {
        int currentHp = game.getHp();
        String output = String.format("%d/7", currentHp);
        System.out.println("HP: " + output);
    }

    private void refreshTries() {
        Set<String> guesses = game.getTries();
        StringBuilder stringBuilder = new StringBuilder();

        for(String s : guesses){
            stringBuilder.append(s).append(" ");
        }

        String output = stringBuilder.toString();
        System.out.println("PRÓBY: " + output);
    }

    public void runConsoleGame() {
        Scanner scanner = new Scanner(System.in);
        String guess;

        while(!game.isGameOver()){
            System.out.println("Podaj literę/hasło: ");
            guess = scanner.next();
            game.guess(guess);

            refreshConsole();
            System.out.println();
        }

        if (game.isWin()){
            System.out.println("Gratulacje, WYGRAŁEŚ");
        }

        if (game.isLose()) {
            System.out.println("Niestety przegrywasz :(");
        }
    }
}
