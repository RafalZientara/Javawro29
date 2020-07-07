package pl.com.sda.rafal.zientara.apps.lesson3.Hangman;

import pl.com.sda.rafal.zientara.apps.lesson2.hangman.Hangman;

public class MainHangman {
    public static void main(String[] args) {
        //HangmanWindow hangmanWindow = new HangmanWindow();
        HangmanConsole hangmanConsole = new HangmanConsole();
        hangmanConsole.runConsoleGame();

    }
}
