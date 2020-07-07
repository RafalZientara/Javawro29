package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

import pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors.Choice;

public interface TranslationsInterface {
    String getPlayerActionText(String nick, Choice choice);

    String getPlayerWinText(String nick);

    String getDrawText();
}
