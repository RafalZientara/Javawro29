package pl.com.sda.rafal.zientara.apps.lesson3_Swing.RockPaperScissors;

public class StonedPlayer implements Player {

    @Override
    public Choice getAction() {
        return Choice.ROCK;
    }
}
