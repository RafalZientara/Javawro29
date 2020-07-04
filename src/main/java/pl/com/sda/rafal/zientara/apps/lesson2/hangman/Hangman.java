package pl.com.sda.rafal.zientara.apps.lesson2.hangman;

import java.util.HashSet;
import java.util.Set;

public class Hangman {

    private String puzzle;
    private Set<String> guessList = new HashSet<>();
    private int hp = 7;

    public void setPuzzle(String puzzle) {
        //todo
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
        if(hp>0) {
            if (guess.length() == 1) {
                guessList.add(guess.toLowerCase());
                if (!puzzle.toLowerCase().contains(guess.toLowerCase())) {
                    hp--;
                }
            } else if (guess.equalsIgnoreCase(puzzle)) {
                for (int i = 0; i < puzzle.length(); i++) {
                    String character = puzzle.substring(i, i + 1);
                    guessList.add(character);
                }
            } else {
                hp--;
            }
        } else {
            System.out.println("Game Over");
        }

    }

    public int getHp() {
        return hp;
    }

    public boolean isWin() {
        return getOutput().equals(puzzle);
    }
}
