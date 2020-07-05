package pl.com.sda.rafal.zientara.apps.lesson3.game;

import java.util.Random;

public class RandomPlayer extends Player {
    public RandomPlayer(String nick) {
        super(nick);
    }

    @Override
    public Choice getAction() {
        Random random = new Random();
        int value = random.nextInt(3);
        switch (value) {
            case 0:
                return Choice.ROCK;
            case 1:
                return Choice.PAPER;
            default:
                return Choice.SCISSORS;
        }
    }
}
