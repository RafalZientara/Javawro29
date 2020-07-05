package pl.com.sda.rafal.zientara.apps.homework.zbior1.animals;

public class MainPets {
    public static void main(String[] args) {
        Pet pies = new Dog("futro",6);
        pies.makeSound();
        System.out.println(pies.getCountOfLegs());

        Fish karp = new Fish("łuski");
        karp.makeSound();
        System.out.println(karp.getCountOfLegs());
        System.out.println(karp.breathUnderwater());
    }
}
