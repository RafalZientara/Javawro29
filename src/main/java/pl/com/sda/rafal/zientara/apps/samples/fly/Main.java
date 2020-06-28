package pl.com.sda.rafal.zientara.apps.samples.fly;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
        Flyweight configInfo = new Flyweight();

        String screen_size = configInfo.getConfig("screen_size");
        System.out.println(screen_size);
        System.out.println(configInfo.getConfig("screen_size"));
        System.out.println(configInfo.getConfig("screen_size"));
        System.out.println(configInfo.getConfig("screen_size"));
        System.out.println(configInfo.getConfig("screen_size"));
        System.out.println(configInfo.getConfig("screen_size"));
        System.out.println(configInfo.getConfig("screen_size"));
        //Czas trwania [ms]: 2803.4583
        //vs flyweight!!! Czas trwania [ms]: 408.43652

        //catche

        long end = System.nanoTime();
        long diff = end - start;
        System.out.println("Czas trwania [ms]: " + diff / 1000000f);
    }
}
