package pl.com.sda.rafal.zientara.apps.samples.c_operational.observer_demo.simple;

import java.util.List;
import java.util.Optional;

public class CostsCounter implements Cart.Observer {

    @Override
    public void onCartChanged(List<String> items) {
        //sposob 1
        int cost = 0;
        for (String item : items) {
            if (item != null) {
                cost += item.length();
            } else {
                cost += -1;
            }
        }

        //sposob 2
        Optional<Integer> costsOptional = items.stream()
                .map(String::length)
                .reduce((x, acc) -> x + acc);

        if (costsOptional.isPresent()) {
            System.out.println("(cc) Cale zakupy kosztują: " + costsOptional.get());
        } else {
            System.out.println("(cc) Koszyk pusty!");
        }
    }

}
