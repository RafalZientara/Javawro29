package pl.com.sda.rafal.zientara.apps.homework.zbior1.delta;

import pl.com.sda.rafal.zientara.apps.homework.zbior1.delta.Delta;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        System.out.println("Podaj współczynniki równania kwadratowego a*x^2 + b*x + c, a, b i c");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a =");
        double a = scanner.nextDouble();
        System.out.println("b =");
        double b = scanner.nextDouble();
        System.out.println("c =");
        double c = scanner.nextDouble();

        Delta equation = new Delta(a, b, c);
        System.out.println("Delta równania: " + equation.countDelta());
        double[] zeros = equation.getZeros();
        if (zeros.length == 0) {
            System.out.println("Równanie nie ma rozwiązań");
        } else {
            System.out.println("Miejsca zerowe: " + zeros);
        }
    }

}
