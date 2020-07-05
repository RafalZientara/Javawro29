package pl.com.sda.rafal.zientara.apps.homework.zbior1.figures;

public class MainTriangle {

    public static void main(String[] args) {
        drawRect(5);
        System.out.println();
        System.out.println();
        drawTriangle(5);
    }

    private static void drawRect(int size) {
        for (int i = 0; i < size; i++) {
            drawHash(size);
            System.out.println();
        }
    }

    private static void drawTriangle(int size) {
        for (int i = 0; i < size; i++) {
            drawHash(i + 1);
            System.out.println();
        }
    }

    private static void drawHash(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("#");
        }
    }
}
