package C03_Strings.P09_Separate_the_Numbers;

import java.util.*;
import org.testng.Assert;


class InputData {
    static int iSize;          // input size
    static String[] iStrings;  // input string array

    static void getData() {
        Scanner in = new Scanner(System.in);
        iSize = in.nextInt();
        iStrings = new String[iSize];
        for (int index = 0; index < iSize; index++) {
            iStrings[index] = in.next();
        }

        in.close();
    }

    static void printData() {
        String output = (
             "\n"
              + "iSize:    " + iSize + "\n"
              + "iStrings: " + Arrays.toString(iStrings) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static String solve_1st(int size, String[] strs) {
        String answer = "";

        for (String str : strs) {
            int len = str.length();
            boolean beautiful = false;
            int firstValue = 0;

            moreDigits:
            for (int i = 0; i < len - 1; i++) {
                int x = Character.getNumericValue(str.charAt(i));
                int y = Character.getNumericValue(str.charAt(i + 1));

                if (y - x == 1) {
                    beautiful = true;
                    if (firstValue == 0) {
                        firstValue = x;
                    }
                } else {
                    beautiful = false;
                    break moreDigits;
                }
            }

            if (beautiful)
                answer += answer.isEmpty() ? "YES " + firstValue : "\nYES " + firstValue;
            else
                answer += answer.isEmpty() ? "NO " : "\nNO ";
        }
        return (answer);
    }

    static String getBeautiful(int size, String[] strs) {
        // Another Java solution, building up a test sequence string for each
        // possible starting number and then comparing to the original (from
        // the Discussions page).

        String answer = "";

        for (String str : strs) {
            boolean valid = false;
            long firstX = -1;
            // Try each possible starting number
            for (int i = 1; i <= str.length()/2; ++i) {
                long x = Long.parseLong(str.substring(0,i));
                firstX = x;
                // Build up sequence starting with this number
                String test = Long.toString(x);
                while (test.length() < str.length()) {
                    test += Long.toString(++x);
                }
                // Compare to original
                if (test.equals(str)) {
                    valid = true;
                    break;
                }
            }
            if (valid)
                answer += answer.isEmpty() ? "YES " + firstX : "\nYES " + firstX;
            else
                answer += answer.isEmpty() ? "NO " : "\nNO ";
        }
        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( getBeautiful(iSize, iStrings) );

        } else {

            iStrings = new String[] {"1112"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = getBeautiful(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES 11");

            iStrings = new String[] {"12345"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = getBeautiful(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES 1");

            iStrings = new String[] {"1234"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = getBeautiful(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES 1");

            iStrings = new String[] { "1234", "91011", "99100", "101103", "010203", "13", "1" };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = getBeautiful(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES 1\nYES 9\nYES 99\nNO \nNO \nNO \nNO ");
        }
    }
}
