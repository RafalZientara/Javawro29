package pl.com.sda.rafal.zientara.apps.lesson2.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @Test
    public void secretPassword(){
        //Given
        Hangman game = new Hangman();
        //When
        game.setPuzzle("Ala ma kota");
        //Then
        String outPut = game.getOutput();
        assertEquals("... .. ....",outPut);
    }

    @Test
    public void userGuessLettero(){
        //Given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        //When
        game.guess("o");
        //Then
        String outPut = game.getOutput();
        assertEquals("... .. .o..",outPut);
    }
    @Test
    public void userGuessLetterO(){
        //Given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        //When
        game.guess("O");
        //Then
        String outPut = game.getOutput();
        assertEquals("... .. .o..",outPut);
    }
    @Test
    public void userGuessLetterA(){
        //Given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        //When
        game.guess("A");
        //Then
        String outPut = game.getOutput();
        assertEquals("A.a .a ...a",outPut);
    }

    @Test
    public void userGuessWholePuzzle(){
        //Given
        Hangman game = new Hangman();
        game.setPuzzle("Ala ma kota");
        //When
        game.guess("Ala ma kota");
        //Then
        String outPut = game.getOutput();
        assertEquals("Ala ma kota",outPut);
    }
    @Test
    public void userGuessSevenHpOnStart(){
        //Given
        Hangman game = new Hangman();
        //When
        int hp = game.getHp();
        //Then
        assertEquals(7,hp);
    }
    @Test
    public void wrongGuessHurts(){
        //Given
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //When
        game.guess("x");

        //Then
        int hp = game.getHp();
        assertEquals(6,hp);
    }
    @Test
    public void wrongGuessPuzzleHurts(){
        //Given
        Hangman game = new Hangman();
        game.setPuzzle("Ala");

        //When
        game.guess("Okoń");

        //Then
        int hp = game.getHp();
        assertEquals(6,hp);
    }
    @Test
    public void outOfHp(){
        //Given
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //When
        game.guess("x");
        game.guess("c");
        game.guess("v");
        game.guess("b");
        game.guess("n");
        game.guess("m");
        game.guess("l");

        //Then
        int hp = game.getHp();
        assertEquals(0,hp);
    }
    @Test
    public void outOfHpAfterGameOver(){
        //Given
        Hangman game = new Hangman();
        game.setPuzzle("a");

        //When
        game.guess("x");
        game.guess("c");
        game.guess("v");
        game.guess("b");
        game.guess("n");
        game.guess("m");
        game.guess("l");
        game.guess("k");

        //Then
        int hp = game.getHp();
        assertEquals(0,hp);
    }
    @Test
    public void isWin(){
        //Given
        Hangman game = new Hangman();
        //When
        game.setPuzzle("ala");
        game.guess("ala");
        //Then
        assertTrue(game.isWin());
    }

}