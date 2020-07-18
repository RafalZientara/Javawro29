package pl.com.sda.rafal.zientara.apps.lesson4;

public class IncrementMain {

    public static void main(String[] args) {


        int a = 5;

        if (a++ == 5) {//true - najpierw zwraca, potem zwieksza
            //a == 6
        }
        if (++a == 6) {//false  a =7

        }


        int b = 3;
        add(b);
        System.out.println(b);
    }

    public static int add(int a) {
        a++;
        return -1;
    }
}
