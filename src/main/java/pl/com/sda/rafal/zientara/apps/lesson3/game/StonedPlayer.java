package pl.com.sda.rafal.zientara.apps.lesson3.game;

public class StonedPlayer implements Player {
    @Override
    public Choice getAction() {
        return Choice.ROCK;
    }
}
