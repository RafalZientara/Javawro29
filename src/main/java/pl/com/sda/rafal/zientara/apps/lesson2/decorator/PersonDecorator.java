package pl.com.sda.rafal.zientara.apps.lesson2.decorator;

public abstract class PersonDecorator implements Person {
    protected Person decoratedPerson;

    public PersonDecorator(Person decoratedPerson) {
        this.decoratedPerson = decoratedPerson;
    }
}
