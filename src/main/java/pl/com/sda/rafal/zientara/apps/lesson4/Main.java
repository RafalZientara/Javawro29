package pl.com.sda.rafal.zientara.apps.lesson4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> list = Arrays.asList(
                new Person("lol",1),
                new Person("wow",1),
                new Person("rotfl",3));

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return Integer.compare(person.age,t1.age);
            }
        });


        Person janusz = new Person("Janusz", 45);

        janusz.count(1,1d);







        LocalDate now = LocalDate.now();
        LocalDate firstDayDate = now.withDayOfMonth(1);
        DayOfWeek dayOfWeek = firstDayDate.getDayOfWeek();
        int value = dayOfWeek.getValue();//ktory dzien tygodnia
        LocalDate currentDate = firstDayDate;

        for (int i = 1; i< value; i++) {
//            System.out.print("\t");//1
            System.out.print("...");//2
        }

        for (int i = 1; i <= now.lengthOfMonth(); i++) {
//            System.out.print(currentDate.getDayOfMonth() + "\t");//1
            System.out.printf("%2d ",currentDate.getDayOfMonth());//2
            DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
//            System.out.print(currentDayOfWeek.name() + "  ");

            if (currentDayOfWeek == DayOfWeek.SUNDAY) {
                System.out.println();
            }

            currentDate = currentDate.plusDays(1);
        }

    }
}
