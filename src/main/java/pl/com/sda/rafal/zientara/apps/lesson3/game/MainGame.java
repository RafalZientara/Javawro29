package pl.com.sda.rafal.zientara.apps.lesson3.game;

public class MainGame {

    public static void main(String[] args) {
        Player player1 = new StonedPlayer();
        Player player2 = () -> Choice.SCISSORS;

        Game game = new Game(player1, player2);
        game.play();
    }
}
