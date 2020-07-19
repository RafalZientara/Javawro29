package pl.com.sda.rafal.zientara.apps.lesson4.eq;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Julek", 14);
        Person person2 = new Person("Julek", 14);

        if(person1 == person2){
            System.out.println("takie same 1");
        } //
        if (person1.equals(person2)) {
            System.out.println("takie same 2");
        }
        if (person1.hashCode() == person2.hashCode()) {
            System.out.println("takie same 3");
        }
    }

    static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
