package pl.com.sda.rafal.zientara.apps.lesson4;

public class Person /*implements Comparable<Person> */ {

    final String name;
    final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int count() {
        return 1;
    }

    public double count(double wow) {
        return wow + 1;
    }

    public int count(int wow) {
        return wow + 1;
    }

    public int count(int wow, double wow2) {
        return count(wow, (int)wow2);
    }

    public int count(int wow, int wow2) {
        return (wow + 10 + wow2);
    }

    public int count(double wow2, int wow) {
        return (int) (wow + 1500100900 + wow2);
    }


   /* @Override
    public int compareTo(Person person) {
        return Integer.compare(person.age, this.age);
    }*/
}
