package pl.com.sda.rafal.zientara.apps.lesson2.decorator;

public class EngineerDecorator implements Person {
    private Person decoratedPerson;

    public EngineerDecorator(Person decoratedPerson) {
        this.decoratedPerson = decoratedPerson;
    }

    @Override
    public String getName() {
        return "inż. " + decoratedPerson.getName();
    }

    @Override
    public double getHeight() {
        return decoratedPerson.getHeight();
    }

    @Override
    public String getLook() {
        return decoratedPerson.getLook() + " wygląda mądrze";
    }

}
