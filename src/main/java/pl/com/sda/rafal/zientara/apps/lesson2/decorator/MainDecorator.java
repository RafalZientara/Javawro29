package pl.com.sda.rafal.zientara.apps.lesson2.decorator;

public class MainDecorator {

    public static void main(String[] args) {
        Human ken = new Human("Ken", 181);
        HighShoesDecorator highShoes = new HighShoesDecorator(15, ken);
        EngineerDecorator engineer = new EngineerDecorator(highShoes);

        PersonDecorator personDecorator = highShoes;
        Person person = highShoes;


        printInfo(engineer);
    }

    public static void printInfo(Person person) {
        System.out.println("Nazywam się " + person.getName());
        System.out.printf("Jestem taki wysoki na %.2f \n", person.getHeight());
        System.out.println(person.getLook());
    }
}
