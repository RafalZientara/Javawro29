package pl.com.sda.rafal.zientara.apps.lesson3.game;

public class StonedPlayer extends Player {

    public StonedPlayer() {
        super("Snoop Dog");
    }

    public StonedPlayer(String nick) {
        super(nick);
    }

    @Override
    public Choice getAction() {
        return Choice.ROCK;
    }
}
