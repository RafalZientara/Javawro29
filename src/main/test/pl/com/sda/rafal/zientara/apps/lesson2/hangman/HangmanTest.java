package pl.com.sda.rafal.zientara.apps.lesson2.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @Test
    public void secretPassword(){
        Hangman game = new Hangman();

        game.setPuzzle("Ala ma kota");

        String output = game.getOutput();
        assertEquals("... .. ....", output);
    }

    @Test
    public void userGuessLetterO(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        game.guess("o");

        String output = game.getOutput();
        assertEquals("... .. .o..", output);
    }

    @Test
    public void userGuessLetterBigO(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        game.guess("O");

        String output = game.getOutput();
        assertEquals("... .. .o..", output);
    }

    @Test
    public void userGuessLetterA(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        game.guess("a");

        String output = game.getOutput();
        assertEquals("A.a .a ...a", output);
    }

    @Test
    public void userGuessWholePassword(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        game.guess("Ala ma kota");

        String output = game.getOutput();
        assertEquals("Ala ma kota", output);
    }

    @Test
    public void userHasSevenUpOnStart(){
        Hangman game = new Hangman();

        int hp = game.getHp();

        assertEquals(7, hp);
    }

    @Test
    public void wrongGuessHurts(){
        Hangman game = new Hangman();
        game.setPuzzle("a");

        game.guess("x");

        int hp = game.getHp();
        assertEquals(6, hp);
    }

    @Test
    public void wrongGuessPuzzleHurts(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala");

        game.guess("Okoń");

        int hp = game.getHp();
        assertEquals(6, hp);
    }

    @Test
    public void outOfHp(){
        Hangman game = new Hangman();
        game.setPuzzle("a");

        game.guess("1");
        game.guess("2");
        game.guess("3");
        game.guess("4");
        game.guess("5");
        game.guess("6");
        game.guess("7");

        int hp = game.getHp();
        assertEquals(0, hp);
    }

    @Test
    public void outOfHpAfterGameOver(){
        Hangman game = new Hangman();
        game.setPuzzle("a");

        game.guess("1");
        game.guess("2");
        game.guess("3");
        game.guess("4");
        game.guess("5");
        game.guess("6");
        game.guess("7");
        game.guess("8");

        int hp = game.getHp();
        assertEquals(0, hp);
    }

    @Test
    public void guessLetterByLetter(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        game.guess("a");
        game.guess("l");
        game.guess("m");
        game.guess("k");
        game.guess("o");
        game.guess("t");

        String output = game.getOutput();
        assertEquals("Ala ma kota", output);
    }

    @Test
    public void isWin(){
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        game.guess("Ala ma kota");

        assertTrue(game.isWin());
    }

    @Test
    public void emptyGuessDoesNothing(){
        Hangman game = new Hangman();
        game.setPuzzle("a");

        game.guess("");

        int hp = game.getHp();
        assertEquals(7, hp);
    }

    @Test
    public void spaceGuessDoesNothing(){
        Hangman game = new Hangman();
        game.setPuzzle("a");

        game.guess(" ");

        String text = "    Ala ma kota       ".trim();

        int hp = game.getHp();
        assertEquals(7, hp);
    }

    @Test
    public void triesShouldBeClearedAfterReset(){
        Hangman game = new Hangman();
        game.setPuzzle("ABBA");
        game.guess("a");

        game.setPuzzle("AC DC");

        assertTrue(game.getTries().isEmpty());
    }

    @Test
    public void hpShouldBeClearedAfterReset(){
        Hangman game = new Hangman();
        game.setPuzzle("ABBA");
        game.guess("x");

        game.setPuzzle("AC DC");

        assertEquals(7, game.getHp());
    }
}