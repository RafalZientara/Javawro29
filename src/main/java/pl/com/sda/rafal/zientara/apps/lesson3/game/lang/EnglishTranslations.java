package pl.com.sda.rafal.zientara.apps.lesson3.game.lang;

import pl.com.sda.rafal.zientara.apps.lesson3.game.Choice;
import pl.com.sda.rafal.zientara.apps.lesson3.game.Translations;

public class EnglishTranslations implements Translations {
    @Override
    public String getPlayerActionText(String nick, Choice choice) {
        return String.format("Player %s chose %s", nick, getActionText(choice));
    }

    private String getActionText(Choice choice) {
        switch (choice) {
            case ROCK:
                return "rock";
            case PAPER:
                return "paper";
            case SCISSORS:
                return "scissors";
        }
        return "";
    }

    @Override
    public String getPlayerWinText(String nick) {
        return String.format("Player %s wins!", nick);
    }

    @Override
    public String getDrawText() {
        return "Draw!";
    }


}
