package pl.com.sda.rafal.zientara.apps.homework.zbior2;

import java.util.Scanner;

public class LevelUpMain {

    public static void main(String[] args) {
        LevelUp levelUp = new LevelUp();
        levelUp.setListener(new LevelUp.LevelListener() {
            @Override
            public void onLevelUp(int level) {
                System.out.printf("LEVEL UP! %d GRATZ!\n", level);
            }
        });
        int exp;
        do {
            System.out.println("Podaj liczbę punktów doświadczenia (liczba całkowita).");
            System.out.println("Jeśli chcesz zakończyć wpisz liczbę 0 lub mniejszą");
            exp = getExperience();
            levelUp.addExp(exp);
        } while (exp > 0);

        System.out.println("Koniec gry!");
        System.out.printf("Uzyskano %d exp\n", levelUp.getExperience());
        System.out.printf("Uzyskano %d poziom\n", levelUp.getLevel());
    }

    private static int getExperience() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String s = scanner.nextLine();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Wpisz poprawnie");
            }
        }
    }
}
