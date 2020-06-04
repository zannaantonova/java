package ee.bcs.java.demo.old.sample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateSample {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(12, 59);
        time.plusHours(1);
        LocalDate date = LocalDate.of(2020, 5, 27);
        date.minusDays(1);
        LocalDateTime dt1= LocalDateTime.of(date, time);
        LocalDateTime dt2= LocalDateTime.of(2020, 5, 29, 15,49);
        System.out.println(time);
        System.out.println(date);
    }
}
