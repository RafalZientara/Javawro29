package pl.com.sda.rafal.zientara.apps.lesson2.decorator;

public class FlopsDecorator extends PersonDecorator {
    private static final double FLOP_HEIGHT = 1;

    public FlopsDecorator(Person decoratedPerson) {
        super(decoratedPerson);
    }

    @Override
    public String getName() {
        return decoratedPerson.getName();
    }

    //ctrl + alt + L - autoformat pliku
    @Override
    public double getHeight() {
        return decoratedPerson.getHeight() + FLOP_HEIGHT;
    }

    @Override
    public String getLook() {
        return decoratedPerson.getLook() + " ma kuboty";
    }
}
