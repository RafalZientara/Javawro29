package pl.com.sda.rafal.zientara.apps.lesson3.game;

public class MainGame {

    public static void main(String[] args) {
        Player player1 = new StonedPlayer();
        Player player2 = () -> Choice.SCISSORS;

        Choice choice1 = player1.getAction();
        Choice choice2 = player2.getAction();

        GameResult result = getResult(choice1, choice2);
        System.out.println("Wynik gry: " + result);

    }

    private static GameResult getResult(Choice choice1,
                                        Choice choice2) {
        if (choice1 == choice2) {
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
