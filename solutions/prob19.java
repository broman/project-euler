import java.util.Calendar;
/*
 * Given the following information:
 * 1 Jan 1900 was a Monday.
 * September, April, June, and November have 30 days.
 * January, March, May, July, August, October, and December have 31 days.
 * February has 28 days, however if the year is a leap year it has 29 days.
 * A leap year occurs on any year divisible by 4, but
 * not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class prob19 {
        public static void main(String[] args) {
            /* I guess it's kinda cheating if I just use built in classes. Oh well. */
            long start = System.nanoTime();
            int sundays = findSundays(1901, 2000);
            long end = System.nanoTime();
            System.out.printf("Sundays: %d\n", sundays);
            System.out.println("Time: " + (end - start) / 100000 + "ms");
    }

    static int findSundays(int begin, int end) {
        int sundays = 0;
        Calendar date = Calendar.getInstance();
        for(; begin <= end; begin++) {
            for(int i = 1; i <= 12; i++) {
                date.set(begin, i, 1);
                if(date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) sundays++;
            }
        }
        return sundays;
    }
}