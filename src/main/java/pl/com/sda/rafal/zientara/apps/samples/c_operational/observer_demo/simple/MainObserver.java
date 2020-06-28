package pl.com.sda.rafal.zientara.apps.samples.c_operational.observer_demo.simple;

import java.util.List;

public class MainObserver {


    public static void main(String[] args) {

        Cart cart = new Cart();

        //ctrl + spacja
        Cart.Observer observer = new Cart.Observer() {
            @Override
            public void onCartChanged(List<String> items) {
                System.out.println("(1) Ile elementow w koszyku?: " + items.size());
            }
        };
        Cart.Observer observer2 = items -> System.out.println("(2) Ile elementow w koszyku?: " + items.size());
        Cart.Observer costsCounter = new CostsCounter();
        CostsCounter costsCounter2 = new CostsCounter();
        Object object = new CostsCounter();

        cart.addObserver(observer);//ctrl + D = duplikuj linię
        cart.addObserver(observer2);
        cart.addObserver(observer2);
        cart.addObserver(costsCounter);


        cart.addItem("Banan");
        cart.addItem("Chleb");
        cart.addItem("Piwo");

        cart.deleteLastItem();


    }
}
