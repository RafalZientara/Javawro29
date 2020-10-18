package pl.com.sda.rafal.zientara.apps.lesson2;

import pl.com.sda.rafal.zientara.apps.lesson2.hangman.Hangman;
import pl.com.sda.rafal.zientara.apps.lesson2.hangman.HangmanWindow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Hangman game = new Hangman();
//        HangmanWindow win = new HangmanWindow();
        game.play();
    }
}
