package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rysowanie koła");
    }
    @Override
    public void resize() {
        System.out.println("Zmiana rozmiaru koła");
    }
    @Override
    public String description() {
        return "Obiekt koła";
    }
    @Override
    public boolean isHide() {
        return false;
    }
}
