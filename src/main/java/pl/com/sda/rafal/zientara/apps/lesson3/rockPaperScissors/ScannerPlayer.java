package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

import java.util.Scanner;

public class ScannerPlayer extends Player {
    private TranslationsInterface translations;
    public ScannerPlayer(String nick, TranslationsInterface translations) {
        super(nick);
        this.translations = translations;
    }

    @Override
    public Choice getAction() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(translations.getActionMessageForScannerPlayer());
            String choice = scanner.next();
            if (choice != null) {
                switch (choice) {
                    case "r":
                        return Choice.ROCK;
                    case "s":
                        return Choice.SCISSORS;
                    case "p":
                        return Choice.PAPER;
                    default:
                        System.out.println(translations.getWrongMessageForScannerPlayer());
                }
            }
        }
    }
}
