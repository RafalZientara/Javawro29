package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

import pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors.lang.ItalianTranslations;

public class Main {
    public static void main(String[] args) {
        TranslationsInterface italianTranslations = new ItalianTranslations();
        Player player1 = new ScannerPlayer("Paolo", italianTranslations);
        Player player2 = new RandomPlayer("Gennaro");

        Game game = new Game(player1, player2, italianTranslations);
        game.play();
    }
}
