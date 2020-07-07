package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

public class StonedPlayer implements PlayerInterface {
    @Override
    public Choice getAction() {
        return Choice.ROCK;
    }
}
