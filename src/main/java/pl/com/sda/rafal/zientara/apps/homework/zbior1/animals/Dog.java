package pl.com.sda.rafal.zientara.apps.homework.zbior1.animals;

public class Dog extends Pet{
    private int legs;

    public Dog() {
        super("futerko");
        legs = 4;
    }

    public Dog(String covered) {
        super(covered);
        legs = 4;
    }

    public Dog(String covered, int legs) {
        super(covered);
        this.legs = legs;
    }

    public void makeSound() {
        System.out.println("Hau hau!");
    }

    public int getCountOfLegs() {
        return 4;
    }

}
