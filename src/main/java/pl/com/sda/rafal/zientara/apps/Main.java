package pl.com.sda.rafal.zientara.apps;

import pl.com.sda.rafal.zientara.apps.singleton.Singleton;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Javawro29");

        Singleton instance = Singleton.getInstance();

//        Singleton s = new Singleton();//error private constructor

//        Singleton.reset();

        Singleton instance1 = Singleton.getInstance();

        String data = instance.data;
        System.out.println(data);
    }
}
