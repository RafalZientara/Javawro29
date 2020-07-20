package pl.com.sda.rafal.zientara.apps.lesson3.game.lang;

import pl.com.sda.rafal.zientara.apps.lesson3.game.Choice;
import pl.com.sda.rafal.zientara.apps.lesson3.game.Translations;

public class FrenchTranslations implements Translations {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @Override
    public String getPlayerActionText(String nick, Choice choice) {
        return String.format("Fyryfy %s%s%s fy %s", ANSI_CYAN, nick, ANSI_RESET, getActionText(choice));
    }

    private String getActionText(Choice choice) {
        switch (choice) {
            case ROCK:
                return ANSI_PURPLE + "żelipapą" + ANSI_RESET;
            case PAPER:
                return ANSI_BLUE + "papieeeer" + ANSI_RESET;
            case SCISSORS:
                return ANSI_RED + "żyletę" + ANSI_RESET;
        }
        return "";
    }

    @Override
    public String getPlayerWinText(String nick) {
        return String.format("Fiu fiu %s! Waka maka", nick);
    }

    @Override
    public String getDrawText() {
        return "Wut!";
    }

    @Override
    public String getAskForActionText() {
        return String.format("Żelti wela r(%s)/p(%s)/s(%s)",
                getActionText(Choice.ROCK),
                getActionText(Choice.PAPER),
                getActionText(Choice.SCISSORS)
        );
    }

    @Override
    public String getWrongText() {
        return "O no no no!";
    }

}
