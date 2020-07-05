package pl.com.sda.rafal.zientara.apps.homework.zbior1.animals;

public abstract class Pet {
    protected String covered;//odp do zad Jaki modyfikator dostępu powinien mieć parametr o pokryciu zwierzęciaw klasie Pet, aby był dostępny w klasie dziedziczącej znajdującej się w innym pakiecie?

    public Pet(String covered) {
        this.covered = covered;
    }

    public String getCovered() {
        return covered;
    }

    public abstract void makeSound();

    public abstract int getCountOfLegs();

}
