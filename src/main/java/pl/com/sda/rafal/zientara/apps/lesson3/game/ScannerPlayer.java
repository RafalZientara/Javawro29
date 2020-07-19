package pl.com.sda.rafal.zientara.apps.lesson3.game;

import java.util.Scanner;

public class ScannerPlayer extends Player {

    public ScannerPlayer(String nick) {
        super(nick);
    }

    @Override
    public Choice getAction() {
        //todo
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wpisz r/p/s");
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
                        System.out.println("Źle!");
                }
            }
        }
    }
}