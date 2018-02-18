package Algorithms.C03_Strings.P23_Richie_Rich;

import java.util.*;
import org.testng.Assert;

class InputData {
    static int iSize;        // input size
    static int iChange;      // input for number of numbers that can be change
    static String iStr;      // input string
    static char[] iString;   // string to make into palindrome as char[]

    static void getData() {
        Scanner in = new Scanner(System.in);
        iSize = in.nextInt();
        iChange = in.nextInt();
        iString = in.next().toCharArray();

        in.close();
    }

    /*
    Convert to palindrome, then convert to largest possible number

    Richie Rich
    https://www.hackerrank.com/challenges/richie-rich

    Learning:

    •  A two pass solution is required.

    • 1st pass: Converts string into a palindrome using largest of two values.
      Use an additional array to track in which position a change was made.

    • 2nd pass: Start from the ends and make 1 or 2 chars a '9' when:
      • Char is not '9' and
      • Additional change is allowed.

    */

    static void printData() {
        String output = (
            "\n"
            + "iSize:    " + iSize + "\n"
            + "iChange:  " + iChange + "\n"
            + "iString:  " + new String(iString) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;


    static String solve(int size, int change, char[] str) {
        int back = str.length - 1;
        int len = str.length;
        int center = str.length / 2;
        int[] recoredOfChagne = new int[size / 2];

        // Convert string into a Palindrome
        for (int front = 0; front < len / 2; front++) {
            if (change >= 0) {

                if (str[front] != str[back - front]) {
                    if (str[front] < str[back - front]) {
                        str[front] = str[back - front];
                    } else {
                        str[back - front] =  str[front];
                    }
                    change = change - 1;
                    recoredOfChagne[front] = 1;
                }

                if (change < 0) {
                    return "-1";
                }

            } else {
                return "-1";
            }
        }

        // Convert to largest possible number
        for (int front = 0; front < len / 2; front++) {

            // Stop when no more chagnes are allowed
            if (change <= 0) {
                break;
            }

            // If char is 9, then ignore
            if (str[front] == '9') {
                continue;
            }

            // Make one change
            if (change >= 1 && recoredOfChagne[front] == 1) {
                str[front] = '9';
                str[back - front] = '9';
                change = change - 1;
            }

            // Make 2 changes
            if (change >= 2 && recoredOfChagne[front] == 0) {
                str[front] = '9';
                str[back - front] = '9';
                change = change - 2;
            }
        }

        // Change center to 9
        if (str.length % 2 == 1 && str[center] != '9' && change > 0) {
            str[center] = '9';
        }

        return (String.valueOf(str));
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println(solve(iSize, iChange, iString));

        } else {

            iChange = 1;
            iStr = "3943";
            iString = iStr.toCharArray();
            iSize = iStr.length();
            if (DEBUG) printData();
            actual = solve(iSize, iChange, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "3993");

            iChange = 3;
            iStr = "092282";
            iString = iStr.toCharArray();
            iSize = iStr.length();
            if (DEBUG) printData();
            actual = solve(iSize, iChange, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "992299");

            iChange = 1;
            iStr = "0011";
            iString = iStr.toCharArray();
            iSize = iStr.length();
            if (DEBUG) printData();
            actual = solve(iSize, iChange, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "-1");

            iChange = 0;
            iStr = "101";
            iString = iStr.toCharArray();
            iSize = iStr.length();
            if (DEBUG) printData();
            actual = solve(iSize, iChange, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "101");

            iChange = 1;
            iStr = "101";
            iString = iStr.toCharArray();
            iSize = iStr.length();
            if (DEBUG) printData();
            actual = solve(iSize, iChange, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "191");

            iChange = 2;
            iStr = "101";
            iString = iStr.toCharArray();
            iSize = iStr.length();
            if (DEBUG) printData();
            actual = solve(iSize, iChange, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "909");

            iChange = 3;
            iStr = "101";
            iString = iStr.toCharArray();
            iSize = iStr.length();
            if (DEBUG) printData();
            actual = solve(iSize, iChange, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "999");

            iChange = 4;
            iStr = "101";
            iString = iStr.toCharArray();
            iSize = iStr.length();
            if (DEBUG) printData();
            actual = solve(iSize, iChange, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "999");
        }
    }
}
