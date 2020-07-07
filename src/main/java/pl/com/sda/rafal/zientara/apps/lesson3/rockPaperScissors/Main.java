package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

import pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors.lang.ItalianTranslations;

public class Main {
    public static void main(String[] args) {
        Player player1 = new RandomPlayer("Paolo");
        Player player2 = new RandomPlayer("Gennaro");
        TranslationsInterface italianTranslations = new ItalianTranslations();

        Game game = new Game(player1, player2, italianTranslations);
        game.play();
    }
}
