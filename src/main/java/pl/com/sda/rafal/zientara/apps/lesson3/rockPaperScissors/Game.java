package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

public class Game {
    private final PlayerInterface player1;
    private final PlayerInterface player2;

    public Game(PlayerInterface player1, PlayerInterface player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(){
        Choice choice1 = player1.getAction();
        Choice choice2 = player2.getAction();

        GameResult result = getResult(choice1, choice2);
        System.out.println("Gracz 1: " + choice1);
        System.out.println("Gracz 2: " + choice2);
        System.out.println("Wynik gry: " + result);
    }

    private static GameResult getResult(Choice choice1, Choice choice2) {
        if (choice1 == choice2){
            return GameResult.DRAW;
        } else if (choice1 == Choice.SCISSORS && choice2 == Choice.PAPER
                || choice1 == Choice.PAPER && choice2 == Choice.ROCK
                || choice1 == Choice.ROCK && choice2 == Choice.SCISSORS){
            return GameResult.PLAYER_1_WIN;
        } else {
            return GameResult.PLAYER_2_WIN;
        }
    }
}
