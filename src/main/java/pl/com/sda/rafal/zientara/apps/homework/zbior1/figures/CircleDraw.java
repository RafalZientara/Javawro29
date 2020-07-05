package pl.com.sda.rafal.zientara.apps.homework.zbior1.figures;

public class CircleDraw {

    public static void draw(int diameter) {
        int radius = diameter / 2;
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                int consti = i - radius;
                int constj = j - radius;
                if ((consti) * (consti) + (constj) * (constj) <= radius * radius) {
                    System.out.print("##");
                } else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
