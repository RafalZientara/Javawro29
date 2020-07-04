package pl.com.sda.rafal.zientara.apps.lesson2.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @Test
    public void secretPassword() {
        //given
        Hangman game = new Hangman();

        //when
        game.setPuzzle("Ala ma kota");

        //then
        String output = game.getOutput();
        assertEquals("... .. ....", output);
    }


    @Test
    public void userGuessLetterO() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        game.guess("o");

        //then
        String output = game.getOutput();
        assertEquals("... .. .o..",
                output);
    }


    @Test
    public void userGuessLetterBigO() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        game.guess("O");

        //then
        String output = game.getOutput();
        assertEquals("... .. .o..",
                output);
    }


    @Test
    public void userGuessLetterA() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        game.guess("a");

        //then
        String output = game.getOutput();
        assertEquals("A.a .a ...a",
                output);
    }

}