package pl.com.sda.rafal.zientara.apps.samples.c_operational.observer_demo.simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {
    private Set<Observer> listeners = new HashSet<>();

    List<String> products = new ArrayList<>();

    public void addObserver(Observer observer) {
        listeners.add(observer);
    }

    public void deleteLastItem() {
        if (!products.isEmpty()) {
            products.remove(products.size() - 1);
            notifyObservers();
        }
    }

    public void addItem(String item) {
        products.add(item);
        notifyObservers();//alt + enter
        System.out.println();
    }

    private void notifyObservers() {//shift + F6
        for (Observer observer : listeners) {
            observer.onCartChanged(products);
        }
    }

    public interface Observer {
        void onCartChanged(List<String> items);
    }
}
