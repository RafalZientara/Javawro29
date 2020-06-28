package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rysuję prostokąt");
    }
    @Override
    public void resize() {
        System.out.println("Zmieniam rozmiar prostokąta");
    }
    @Override
    public String description() {
        return "Obiekt prostokąt";
    }
    @Override
    public boolean isHide() {
        return false;
    }
}
