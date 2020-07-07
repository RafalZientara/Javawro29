package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

public class Main {
    public static void main(String[] args) {
        PlayerInterface player1 = new ScannerPlayer();
        PlayerInterface player2 = new RandomPlayer();

        Game game = new Game(player1, player2);
        game.play();
    }
}
