import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.HashMap;
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
    static final int BEGIN = 1901;
    static final int END = 2001;
    static final HashMap<Integer, Integer> MONTHS = new HashMap<Integer, Integer>();
        public static void main(String[] args) {
            MONTHS.put(1, 1);
            MONTHS.put(2, 4);
            MONTHS.put(3, 4);
            MONTHS.put(4, 0);
            MONTHS.put(5, 2);
            MONTHS.put(6, 5);
            MONTHS.put(7, 0);
            MONTHS.put(8, 3);
            MONTHS.put(9, 6);
            MONTHS.put(10, 1);
            MONTHS.put(11, 4);
            MONTHS.put(12, 6);
            long start = System.nanoTime();
            int sundays = findSundays(BEGIN, END);
            long end = System.nanoTime();
            System.out.printf("Sundays: %d\n", sundays);
            System.out.println("Time: " + (end - start) / 100000 + "ms");
    }

    static int findSundays(int begin, int end) {
        /*
         * This calculation is done easiest using a key-value method.
         * Sunday, being the 1st day of the week. Will hold the value 1.
         * Given the following tables:
         * Table 1.
         * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
         * | Jan | Feb | Mar | Apr | May | Jun | Jul | Aug | Sep | Oct | Nov | Dec |
         * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
         * |  1  |  4  |  4  |  0  |  2  |  5  |  0  |  3  |  6  |  1  |  4  |  6  |
         * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
         * Table 2.
         * +--------+--------+
         * | 1900's | 2000's |
         * +--------+--------+
         * |   0    |    6   |
         * +--------+--------+
         * 
         * We can find the day of the week for any date in the 1900's and 2000's.
         * 1. Take the last 2 digits of the year and divide by 4 without remainder.
         * 2. Add the day of the month (in our case, 1).
         * 3. Add the month's key value from Table 1.
         * 4. If the day is in January of February of a leap year, subtract 1.
         * 5. Add the century code from Table 2.
         * 6. Add the last 2 digits of the year.
         * 7. Modulo by 7. That number (1 - 7) corresponds with the day of the week (Sunday - Saturday)
         */
        int sundays = 0;
        while(begin <= end) {
            for(int i = 1; i <= 12; i++) {
                // 1.
                int dow = begin % 100;
                dow /= 4;
                // 2.
                dow++;
                // 3.
                dow += MONTHS.get(i);
                // 4.
                if(i <= 2 && isLeapYear(begin)) dow--;
                // 5.
                dow += begin < 2000? 0 : 6;
                // 6.
                dow += begin % 100;
                // 7.
                dow %= 7;
                if(dow == 1) sundays++;
            }
            begin++;
        }
        return sundays;
    }
    static boolean isLeapYear(int year) {
        /* 
         * A leap year occurs on any year divisible by 4, but
         * not on a century unless it is divisible by 400. 
        */
        return (year % 400 == 0) && year % 4 == 0;
    }
}