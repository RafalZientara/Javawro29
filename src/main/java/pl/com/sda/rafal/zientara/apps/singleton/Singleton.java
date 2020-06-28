package pl.com.sda.rafal.zientara.apps.singleton;

public class Singleton {

    public String data = "Wow!";

    private static Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance() {//1, 3
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

//    public static void reset() {//2
//        instance = null;
//    }



}
