package pl.com.sda.rafal.zientara.apps.singleton;

public class Singleton {

    public String data = "Wow!";

    private static Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance() {//1, 3
        if (instance == null) { //T1 ,T2
            //T1/T2
            instance = new Singleton();
        }
        return instance;
    }

//    public static void reset() {//2
//        instance = null;
//    }



}
