package pl.com.sda.rafal.zientara.apps.lesson3_Swing.RockPaperScissors;

import java.util.Scanner;

public class ScannerPlayer implements Player{
    Scanner scan = new Scanner(System.in);

    @Override
    public Choice getAction() {
        while(true) {
            System.out.println("Wpisz r/p/s");
            String scanned = scan.next();
            if (scanned.equalsIgnoreCase("r")) {
                return Choice.ROCK;
            } else if (scanned.equalsIgnoreCase("p")) {
                return Choice.PAPER;
            } else if (scanned.equalsIgnoreCase("s")) {
                return Choice.SCISSORS;
            } else {
                System.out.println("Wybierz poprawną opcję");
            }
        }
    }
}
