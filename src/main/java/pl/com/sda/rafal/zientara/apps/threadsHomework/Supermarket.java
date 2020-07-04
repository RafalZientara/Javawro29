package pl.com.sda.rafal.zientara.apps.threadsHomework;

import java.util.*;

//todo zadanko domowe od Katarzyny Żmuda
public class Supermarket {
    private int productCount;
    private Map<String, Integer> shopping = new HashMap<>();
    private List<Thread> customersList = new ArrayList<>();


    public Supermarket(int productCount, int customerCount) {
        this.productCount = productCount;
        for (int i = 1; i <= customerCount; i++) {
            String customerName = "wątek" + i;
            Thread customer = new Thread(() -> {
                while (true)
                    if (!getProduct())
                        return;
            }, customerName);
            customersList.add(customer);
            shopping.put(customerName, 0);
        }
    }

    public void startSale() {
        for (Thread thread : customersList) {
            thread.start();
        }

        try {
            for (Thread thread : customersList) {
                thread.join();
            }
        } catch (InterruptedException ex) {
        }

        for (String customerName : shopping.keySet()) {
            System.out.println(customerName + " " + shopping.get(customerName));
        }

        shopping.values().stream()
                .reduce(Integer::sum)
                .ifPresent(x -> System.out.println("Suma pobranych: " + x));
    }

    private synchronized boolean getProduct() {
        if (productCount > 0) {
            productCount--;
            String customerName = Thread.currentThread().getName();
            int customerProducts = shopping.getOrDefault(customerName, 0) + 1;
            shopping.put(customerName, customerProducts);
            int sleepTime = new Random().nextInt(11);
            try {
                Thread.currentThread().sleep(sleepTime);
            } catch (InterruptedException ex) {
            }
            return true;
        } else {
            return false;
        }
    }
}
