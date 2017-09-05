package C02_Implementation.P09_Day_of_the_Programmer;

import java.util.*;


/*


Day of the programmer 256th day of the year
- September 13 during common years
- September 12 in leap years

Inclusive range
- 1700 to 2700 inclusive range

Calendars
- Julian calendar    Gregorian calendar
  1700..1917         1918..2700
                     Jan 31 -> Feb 14
                               32nd day of the year
if (year < 1700) {
    // error: out of range
} else if (year <= 1917) {
    Julian calendar()
    Julian leap year()
} else if (year = 1918) {
    transition year()
} else if (year <= 2700) {
    Gregorian calendar()
    Gregorian leap year(();
} else {
    // error: out of range
}

Julian leap year()
- year / 4

 Gregorian leap year(();
 - year / 400
 or
 - year / 4 and not divisible by 100

 */

class InputData {
    static int iYear;       // array size

    static void getData() {
        Scanner in = new Scanner(System.in);
        iYear = in.nextInt();
        in.close();
    }

    static void printData() {
        String output = (
                "\n" +
                "year: " +iYear + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static String dateToString(int day, int month, int year) {
        return (String.format("%02d", day)   + "." +
                String.format("%02d", month) + "." +
                String.format("%04d", year)
        );
    }

    static boolean isJulianLeapYear(int year) {
        if ( (year % 4) == 0 )
            return true;
        else
            return false;
    }

    static boolean isGregorianLeapYear(int year) {
        if ( (year % 400) == 0 )
            return true;
        if ( (year % 4 == 0) && (year % 100 != 0) )
            return true;
        return false;
    }

    static String DayOfTheProgrammer(int year) {
        int day;
        int month;
        String answer;
        if (year < 1700) {
            throw new IllegalArgumentException("ERROR: " + year + " not valid because less than 1700");
        } else if (year <= 1917) {
            day = 13;
            month = 9;
            if (isJulianLeapYear(year)) day = day - 1;
            answer = dateToString(day, month, year);
        } else if (year == 1918) {
            day = 13 + 13; // do adjustment for 13 skipped days in the year 1918
            month = 9;
            // not a leap year using Julian or Gregorian calculation
            answer = dateToString(day, month, year);
        } else if (year <= 2700) {
            day = 13;
            month = 9;
            if (isGregorianLeapYear(year)) day = day - 1;
            answer = dateToString(day, month, year);
        } else {
            throw new IllegalArgumentException("ERROR: " + year + " not valid because greater than 2700");
        }
        return answer;
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( DayOfTheProgrammer(iYear) );  //

        } else {

            iYear = 1700;
            if (DEBUG) printData();
            System.out.println( DayOfTheProgrammer(iYear) );  // 12.09.1700

            iYear = 1701;
            if (DEBUG) printData();
            System.out.println( DayOfTheProgrammer(iYear) );  // 13.09.1701

            iYear = 2000;
            if (DEBUG) printData();
            System.out.println( DayOfTheProgrammer(iYear) );  // 12.09.2000

            iYear = 2001;
            if (DEBUG) printData();
            System.out.println( DayOfTheProgrammer(iYear) );  // 13.09.2001

            iYear = 1918;
            if (DEBUG) printData();
            System.out.println( DayOfTheProgrammer(iYear) );  // 26.09.1918

        }
    }
}
