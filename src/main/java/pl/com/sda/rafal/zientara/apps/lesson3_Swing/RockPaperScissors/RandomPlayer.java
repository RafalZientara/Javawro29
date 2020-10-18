package pl.com.sda.rafal.zientara.apps.lesson3_Swing.RockPaperScissors;

import java.util.Random;

public class RandomPlayer implements Player {
    @Override
    public Choice getAction() {
        Random random = new Random();
        int rand = random.nextInt(3);
        if (rand == 0) {
            return Choice.ROCK;
        } else if ( rand == 1 ) {
            return Choice.PAPER;
        } else {
            return Choice.SCISSORS;
        }
    }
}
