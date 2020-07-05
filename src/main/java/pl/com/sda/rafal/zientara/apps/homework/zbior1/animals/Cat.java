package pl.com.sda.rafal.zientara.apps.homework.zbior1.animals;

public class Cat extends Pet{
    private int legs;

    public Cat() {
        super("futerko");
        legs = 4;
    }

    public Cat(String covered) {
        super(covered);
        legs = 4;
    }

    public Cat(String covered, int legs) {
        super(covered);
        this.legs = legs;
    }

    public void makeSound() {
        System.out.println("Miauu Miauu");
    }

    public int getCountOfLegs() {
        return legs;
    }

}
