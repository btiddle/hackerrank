package Algorithms.C01_Warmup.P10_Time_Conversion;

import java.util.*;

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static String getData() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        return s;
    }

    static String timeConversion(String s) {
        // 00:00:00AM
        // 0123456789
        int hour = Integer.parseInt(s.substring(0,2));
        int min  = Integer.parseInt(s.substring(3,5));
        int sec  = Integer.parseInt( s.substring(6,8));
        boolean isAM = "AM".equals(s.substring(8,10));

        if (hour == 12 & isAM) hour = 0;
        if (hour != 12 & !isAM) hour = hour + 12;

        return (
                String.format("%02d", hour) + ":" +
                        String.format("%02d", min) + ":" +
                        String.format("%02d", sec)
        );
    }

    public static void main(String[] args) {
        String data = "";

        if (!TEST) {
            data = getData();
            System.out.println(timeConversion(data));
        } else {
            System.out.println(timeConversion("07:05:45PM")); // 19:05:45
            System.out.println(timeConversion("12:00:00AM")); // 00:00:00
            System.out.println(timeConversion("12:00:00PM")); // 12:00:00
            System.out.println(timeConversion("01:01:01AM")); // 01:01:01
            System.out.println(timeConversion("02:02:03PM")); // 14:02:03
            System.out.println(timeConversion("00:00:00AM")); // 00:00:00
            System.out.println(timeConversion("00:00:00PM")); // 12:00:00
        }
    }
}
