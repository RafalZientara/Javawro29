package pl.com.sda.rafal.zientara.apps.lesson2.hangman;

import java.util.HashSet;
import java.util.Set;

public class Hangman {
    private String puzzle = "";
    private Set<String> guessList = new HashSet<>();

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public String getOutput() {
        String output = "";
        for (int i = 0; i < puzzle.length(); i++) {
            String character = puzzle.substring(i, i + 1);

            if (" ".equals(character)) {
                output += " ";
            } else if (guessList.contains(character.toLowerCase())) {
                output += character;
            } else {
                output += ".";
            }
        }
        return output;
    }

    public void guess(String guess) {
        guessList.add(guess.toLowerCase());
    }
}
