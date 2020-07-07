package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

public class Game {
    private final Player player1;
    private final Player player2;
    private TranslationsInterface translations;

    public Game(Player player1, Player player2, TranslationsInterface translations) {
        this.player1 = player1;
        this.player2 = player2;
        this.translations = translations;
    }

    public void play(){
        Choice choice1 = player1.getAction();
        Choice choice2 = player2.getAction();

        GameResult result = getResult(choice1, choice2);

        System.out.println(translations.getPlayerActionText(player1.getNick(), choice1));
        System.out.println(translations.getPlayerActionText(player2.getNick(), choice2));

        switch (result){
            case PLAYER_1_WIN:
                System.out.println(translations.getPlayerWinText(player1.getNick()));
                break;
            case PLAYER_2_WIN:
                System.out.println(translations.getPlayerWinText(player2.getNick()));
                break;
            case DRAW:
                System.out.println(translations.getDrawText());
        }
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
