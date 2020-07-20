package pl.com.sda.rafal.zientara.apps.lesson4.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class MainCalendar {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate firstDayDate = now.withDayOfMonth(1);
        DayOfWeek dayOfWeek = firstDayDate.getDayOfWeek();
        int value = dayOfWeek.getValue();
        LocalDate currentDate = firstDayDate;

        for (int i = 1; i < value; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <= now.lengthOfMonth(); i++) {
            System.out.print(i + "\t");
            DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
//            System.out.print(currentDayOfWeek.name() + " ");

            if (currentDayOfWeek == DayOfWeek.SUNDAY){
                System.out.println("");
            }

            currentDate = currentDate.plusDays(1);
        }
    }
}
