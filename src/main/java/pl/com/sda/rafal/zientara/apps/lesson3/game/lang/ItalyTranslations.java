package pl.com.sda.rafal.zientara.apps.lesson3.game.lang;

import pl.com.sda.rafal.zientara.apps.lesson3.game.Choice;
import pl.com.sda.rafal.zientara.apps.lesson3.game.Translations;


//zad 2
public class ItalyTranslations implements Translations {
    @Override
    public String getPlayerActionText(String nick, Choice choice) {
        return String.format("Giocatore %s scegliere %s", nick, getActionText(choice));
    }

    private String getActionText(Choice choice) {
        switch (choice) {
            case ROCK:
                return "calcolo";
            case PAPER:
                return "carta";
            case SCISSORS:
                return "cesoie";
        }
        return "";
    }

    @Override
    public String getPlayerWinText(String nick) {
        return String.format("Il giocatore ha vinto %s!", nick);
    }

    @Override
    public String getDrawText() {
        return "Disegnare!";
    }


}
