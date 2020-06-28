package pl.com.sda.rafal.zientara.apps.samples.b_structural.facade_demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Kelner {

    public void przyniesPiwo(String beerSize){
        System.out.println("Patrze pod blat mam piwo");
        System.out.println("Odkapslowane");
        System.out.println("Przelane do kufla");
        System.out.println("Prosze, " + beerSize + " piwo.");
    }

    public void podajMenuVege(){
        String pozycja1 = "kapusta z grochem";
        String pozycja2 = "sojowe kotlety";
        String pozycja3 = "golabki z kasza";
        ArrayList<String> vegeMenu = new ArrayList<>();
        vegeMenu.add(pozycja1);
        vegeMenu.add(pozycja2);
        vegeMenu.add(pozycja3);

        System.out.println("Menu vege to: " + vegeMenu.toString());
    }

    public void podajMenuMiesne(){
        System.out.println("Menu miesne to: " + MeatMenu.getMenu());
    }

    public void rachunekProsze(){
        Random random = new Random();
        System.out.println("Nalezy się " + random.nextInt(100) + "." + random.nextInt(99) + " PLN");
    }
}
