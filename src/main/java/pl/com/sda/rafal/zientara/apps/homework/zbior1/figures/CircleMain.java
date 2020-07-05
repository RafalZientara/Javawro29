package pl.com.sda.rafal.zientara.apps.homework.zbior1.figures;


import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj średnicę koła");
        int radius = scanner.nextInt();
        if (radius % 2 == 1) {
            CircleDraw.draw(radius);
        } else {
            System.out.println("Nie bede rysowac parzystego! >:D");
        }
    }
}