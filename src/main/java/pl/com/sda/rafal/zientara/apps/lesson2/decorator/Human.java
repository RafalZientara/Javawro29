package pl.com.sda.rafal.zientara.apps.lesson2.decorator;

public class Human implements Person {
    private String name;
    private double height;

    public Human(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public String getLook() {
        return "piękny";
    }
}
