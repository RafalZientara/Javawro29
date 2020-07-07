package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors.lang;

import pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors.Choice;
import pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors.TranslationsInterface;

public class ItalianTranslations implements TranslationsInterface {
    @Override
    public String getPlayerActionText(String nick, Choice choice) {
        return String.format("Giocatore %s sceglie %s", nick, getActionText(choice));
    }

    @Override
    public String getPlayerWinText(String nick) {
        return String.format("Giocatore %s vince!", nick);
    }

    @Override
    public String getDrawText() {
        return "Pareggio!";
    }

    private String getActionText(Choice choice){
        switch (choice){
            case ROCK:
                return "sasso";
            case PAPER:
                return "carta";
            case SCISSORS:
                return "forbici";
            default:
                return "";
        }
    }
}
