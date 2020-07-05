package pl.com.sda.rafal.zientara.apps.lesson3.game;

public interface Translations {
    String getPlayerActionText(String nick, Choice choice);

    String getPlayerWinText(String nick);

    String getDrawText();
}
