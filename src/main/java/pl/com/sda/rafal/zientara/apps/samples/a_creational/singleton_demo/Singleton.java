package pl.com.sda.rafal.zientara.apps.samples.a_creational.singleton_demo;

public class Singleton {

    // przypadek "lazy"
    private static Singleton instance = null; // domyślnie instancja jest nullem

    private Singleton() {
        // Ten fragment istnieje tylko po to, by Singleton nie inicjalizował się od razu
    }

    public static Singleton getInstance() { //dopiero wywołanie tej metody inicjalizuje singletona
        if (instance == null) {
            instance = new Singleton(); // to jest miejsce faktycznej inicjalizacji w metodzie
        }
        return instance; // jeśli już był inicjalizowany, to po prostu zwraca starą instancję
    }

    protected void webConnection() {
        System.out.println("connected to web");
    }
}
