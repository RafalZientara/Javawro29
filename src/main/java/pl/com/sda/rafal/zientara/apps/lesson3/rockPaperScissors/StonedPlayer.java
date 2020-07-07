package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

public class StonedPlayer extends Player {
    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public Choice getAction() {
        return Choice.ROCK;
    }
}
