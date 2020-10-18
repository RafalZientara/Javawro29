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
    public void usegGuessLetterO() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        game.guess("o");

        //then
        String output = game.getOutput();
        assertEquals("... .. .o..", output);
    }

    @Test
    public void usegGuessLetterBigO() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        game.guess("O");

        //then
        String output = game.getOutput();
        assertEquals("... .. .o..", output);
    }

    @Test
    public void usegGuessLetterA() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        game.guess("a");

        //then
        String output = game.getOutput();
        assertEquals("A.a .a ...a", output);
    }

    @Test
    public void userGuessWholePuzzle() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        game.guess("Ala ma kota");

        //then
        String output = game.getOutput();
        assertEquals("Ala ma kota", output);

    }

    @Test
    public void userHasSevenHpOnStart() {
        //given
        Hangman game = new Hangman();

        //when
        int hp = game.getHp();

        //then
        assertEquals(7, hp);
    }

    @Test
    public void wrongGuessLetterHurts() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //when
        game.guess("x");

        //then
        int hp = game.getHp();
        assertEquals(6, hp);
    }

    @Test
    public void emptyGuessDoesNothing() {
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //when
        game.guess("");

        //then
        int hp = game.getHp();
        assertEquals(7, hp);
    }

    @Test
    public void spaceGuessDoesNothing() {
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //when
        game.guess(" ");

        //then
        int hp = game.getHp();
        assertEquals(7, hp);
    }

    @Test
    public void spacesGuessDoesNothing() {
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //when
        game.guess("     ");

        //then
        int hp = game.getHp();
        assertEquals(7, hp);
    }

    @Test
    public void guessWithTrimIsCorrect() {
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //when
        game.guess("   a  ");

        //then
        int hp = game.getHp();
        assertEquals(7, hp);
        String output = game.getOutput();
        assertEquals("a", output);
    }

    @Test
    public void wrongGuessPuzzleHurts() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //when
        game.guess("x");

        //then
        int hp = game.getHp();
        assertEquals(6, hp);
    }

    @Test
    public void outOfHp() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //when
        game.guess("1");
        game.guess("2");
        game.guess("3");
        game.guess("4");
        game.guess("5");
        game.guess("6");
        game.guess("7");

        //then
        int hp = game.getHp();
        assertEquals(0, hp);
    }

    @Test
    public void outOfHpAfterGameOver() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //when
        game.guess("1");
        game.guess("2");
        game.guess("3");
        game.guess("4");
        game.guess("5");
        game.guess("6");
        game.guess("7");
        game.guess("8");

        //then
        int hp = game.getHp();
        assertEquals(0, hp);
    }

    @Test
    public void guessLetterByLetter() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");

        //when
        game.guess("a");
        game.guess("l");
        game.guess("m");
        game.guess("k");
        game.guess("o");
        game.guess("t");

        //then
        String output = game.getOutput();
        assertEquals("Ala ma kota", output);
    }

    @Test
    public void isWin() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        game.guess("Ala ma kota");

        //when

        //then
        assertTrue(game.isWin());
    }

    @Test
    public void TriesShouldBeClearedAfterNewPuzzle() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("ABBA");
        game.guess("a");

        //when
        game.setPuzzle("AC piorun DC");

        //then
        assertTrue(game.getTries().isEmpty());

    }

    @Test
    public void hpShouldBeClearedAfterNewPuzzle() {
        //given
        Hangman game = new Hangman();
        game.setPuzzle("ABBA");
        game.guess("a");

        //when
        game.setPuzzle("AC piorun DC");

        //then
        assertEquals(7, game.getHp());

    }
}