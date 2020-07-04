package pl.com.sda.rafal.zientara.apps.lesson2.decorator;

public class HighShoesDecorator extends PersonDecorator {

    private double shoesHeight;

    public HighShoesDecorator(double shoesHeight, Person decoratedPerson) {
        super(decoratedPerson);
        this.shoesHeight = shoesHeight;
    }

    @Override
    public String getName() {
        return decoratedPerson.getName();
    }

    //ctrl + alt + L - autoformat pliku
    @Override
    public double getHeight() {
        return decoratedPerson.getHeight() + shoesHeight;
    }

    @Override
    public String getLook() {
        return decoratedPerson.getLook() + " ma wysokie buty";
    }
}
