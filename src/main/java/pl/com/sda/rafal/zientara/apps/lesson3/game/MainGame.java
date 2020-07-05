package pl.com.sda.rafal.zientara.apps.lesson3.game;

public class MainGame {

    public static void main(String[] args) {
        Player player1 = new ScannerPlayer();
        Player player2 = new ScannerPlayer();

        Game game = new Game(player1, player2);
        game.play();
    }
}
