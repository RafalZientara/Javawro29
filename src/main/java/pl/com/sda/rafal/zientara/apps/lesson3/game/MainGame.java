package pl.com.sda.rafal.zientara.apps.lesson3.game;

import pl.com.sda.rafal.zientara.apps.lesson3.game.lang.FrenchTranslations;

public class MainGame {

    public static void main(String[] args) {
        Translations translations = new FrenchTranslations();
        Player player1 = new ScannerPlayer("Zdzichu", translations);
        Player player2 = new RandomPlayer("Zbychu");

        Game game = new Game(player1, player2, translations);
        game.play();
    }
}
