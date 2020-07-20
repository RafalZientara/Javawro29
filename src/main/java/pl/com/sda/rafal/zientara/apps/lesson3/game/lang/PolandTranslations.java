package pl.com.sda.rafal.zientara.apps.lesson3.game.lang;

import pl.com.sda.rafal.zientara.apps.lesson3.game.Choice;
import pl.com.sda.rafal.zientara.apps.lesson3.game.Translations;

public class PolandTranslations implements Translations {
    @Override
    public String getPlayerActionText(String nick, Choice choice) {
        return String.format("Gracz %s wybrał %s", nick, getActionText(choice));
    }

    private String getActionText(Choice choice) {
        switch (choice) {
            case ROCK:
                return "kamień";
            case PAPER:
                return "papier";
            case SCISSORS:
                return "nożyce";
        }
        return "";
    }

    @Override
    public String getPlayerWinText(String nick) {
        return String.format("Wygrał gracz %s!", nick);
    }

    @Override
    public String getDrawText() {
        return "Remis!";
    }

    @Override
    public String getAskForActionText() {
        return String.format("Wpisz r(%s)/p(%s)/s(%s)",
                getActionText(Choice.ROCK),
                getActionText(Choice.PAPER),
                getActionText(Choice.SCISSORS)
        );
    }

    @Override
    public String getWrongText() {
        return "Źle!";
    }


}
