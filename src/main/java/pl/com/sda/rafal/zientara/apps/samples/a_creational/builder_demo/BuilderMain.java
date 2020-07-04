package pl.com.sda.rafal.zientara.apps.samples.a_creational.builder_demo;

public class BuilderMain {

    public static void main(String[] args) {
        //Uzywamy Buildera zeby dostac nowy obiekt, zawsze z dobrym stanem i potrzebnymi parametrami
        //Dla obiektów prostych lepsza jest metoda wytwórcza (factory)
        Human adas = new Human.Builder("Male", "Adam", "28")
                .setProgrammer(false)
                .setGenius(true)
                .build(); //shift + F6 = rename

        new Human("male","Zdzichu", "30",true,false);

        System.out.println(adas.getSex());
        System.out.println(adas.getName());
        System.out.println(adas.getAge() + " years old");
        System.out.println("is a rich - " + adas.isRich());
        System.out.println("is a genius - " + adas.isGenius());
        System.out.println();

        Human ewcia = new Human.Builder("Female", "Ewa", "25")
                .setProgrammer(true)
                .setGenius(true)
                .build();

        System.out.println(ewcia.getSex());
        System.out.println(ewcia.getName());
        System.out.println(ewcia.getAge() + " years old");
        System.out.println("is a rich - " + ewcia.isRich());
        System.out.println("is a genius - " + ewcia.isGenius());
        System.out.println();
    }
}
