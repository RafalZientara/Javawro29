package pl.com.sda.rafal.zientara.apps.lesson3.game;

import java.util.Scanner;

public class ScannerPlayer extends Player {

    private final Translations translations;

    public ScannerPlayer(String nick, Translations translations) {
        super(nick);
        this.translations = translations;
    }

    @Override
    public Choice getAction() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(translations.getAskForActionText());
            String value = scanner.next();
            if (value != null) {
                switch (value.toLowerCase()) {
                    case "r":
                    case "rock":
                        return Choice.ROCK;
                    case "s":
                    case "scissors":
                        return Choice.SCISSORS;
                    case "p":
                    case "paper":
                        return Choice.PAPER;
                    default:
                        System.out.println(translations.getWrongText());
                }
            }
        }
    }
}
