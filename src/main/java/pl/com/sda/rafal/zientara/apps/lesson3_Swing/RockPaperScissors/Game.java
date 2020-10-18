package pl.com.sda.rafal.zientara.apps.lesson3_Swing.RockPaperScissors;

public class Game {
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Choice choice1 = player1.getAction();
        Choice choice2 = player2.getAction();

        GameResult result = getResult(choice1, choice2);
        System.out.println("Wynik gry: " + result);
    }

    private static GameResult getResult(Choice choice1, Choice choice2) {
        if (choice1 == choice2) {       //bo jest tylko jeden stan na jeden programie przy użyciu enuma (nie trzeba equals)
            return GameResult.DRAW;
        }
        if (choice1 == Choice.ROCK && choice2 == Choice.SCISSORS ||
                choice1 == Choice.PAPER && choice2 == Choice.ROCK ||
                choice1 == Choice.SCISSORS && choice2 == Choice.PAPER) {
            return GameResult.PLAYER_1_WIN;
        }
        return GameResult.PLAYER_2_WIN;
    }

}
