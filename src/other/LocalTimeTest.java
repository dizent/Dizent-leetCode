package other;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class LocalTimeTest {

    public static void main(String[] args) throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(234);
        LocalTime end = LocalTime.now().plusMinutes(2);
        long i = Duration.between(start,end).getSeconds();
        System.out.println(i);


        LocalDate now= LocalDate.now();
        System.out.println(now);
        LocalDate with =now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(with);
    }
}
