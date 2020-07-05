package pl.com.sda.rafal.zientara.apps.homework.zbior1.animals;

public class Fish extends Pet implements WaterBeing{

    public Fish() {
        super("łuski");
    }

    public Fish(String covered) {
        super(covered);
    }

    public void makeSound() {
        System.out.println("Bulb bulb");
    }

    public int getCountOfLegs() {
        return 0;
    }

    public String breathUnderwater() {
        return  "Wow jestem pod woda i dalej zyje";
    }
}
