package pl.com.sda.rafal.zientara.apps.lesson2.hangman;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Hangman {

    public static final int MAX_HP = 7;
    private String puzzle = "";
    private Set<String> guessList = new HashSet<>();
    private int hp = MAX_HP;

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
        this.guessList.clear();
        this.hp = MAX_HP;
    }

    public String getOutput() {
        String output = "";
        for (int i = 0; i < puzzle.length(); i++) {
            String character = puzzle.substring(i, i+1);

            if (" ".equals(character)){
                output += " ";
            } else if (this.guessList.contains(character.toLowerCase()))
            output += character;
            else {
                output += ".";
            }
        }
        return output;
    }

    public void guess(String guess) {
        if (hp > 0) {
            String normalizedGuess = guess.trim().toLowerCase();
            if (normalizedGuess.length() == 0){
                return;
            }

            if (normalizedGuess.length() == 1) {
                this.guessList.add(normalizedGuess);
                if (!puzzle.toLowerCase().contains(normalizedGuess)) {
                    hp--;
                }
            } else if (normalizedGuess.equalsIgnoreCase(puzzle)) {
                for (int i = 0; i < normalizedGuess.length(); i++) {
                    String character = normalizedGuess.substring(i, i + 1);
                    guessList.add(character);
                }
            } else {
                hp--;
            }
        }
    }

    public int getHp() {
        return hp;
    }

    public boolean isWin() {
        return getOutput().equals(puzzle);
    }

    public Set<String> getTries() {
        Set<String> output = new TreeSet<>(guessList);
        return output;
    }

    public boolean isLose() {
        return hp == 0;
    }

    public boolean isGameOver(){
        return isWin() || isLose();
    }
}
