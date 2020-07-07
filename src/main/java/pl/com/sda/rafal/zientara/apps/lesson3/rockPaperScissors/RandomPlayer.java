package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

import java.util.Random;

public class RandomPlayer extends Player {
    public RandomPlayer(String nick) {
        super(nick);
    }

    @Override
    public Choice getAction() {
        Random random = new Random();
        int choice = random.nextInt(3);
        if (choice == 0){
            return Choice.ROCK;
        } else if (choice == 1){
            return Choice.PAPER;
        } else {
            return Choice.SCISSORS;
        }
    }
}
