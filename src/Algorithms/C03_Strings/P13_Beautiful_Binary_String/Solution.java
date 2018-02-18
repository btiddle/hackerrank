package Algorithms.C03_Strings.P13_Beautiful_Binary_String;

import java.util.*;
import org.testng.Assert;

class InputData {
    static int iSize;          // input size
    static String iString;     // input string

    static void getData() {
        Scanner in = new Scanner(System.in);
        iSize = in.nextInt();
        iString = in.next();

        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "iSize:    " + iSize + "\n"
            + "iString:  " + iString + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    /*

    Count number of occurrences of substring in string

    Beautiful Binary String
    https://www.hackerrank.com/challenges/beautiful-binary-string

    A string is a Beautiful Binary String when it does not contain "010".

    Learning:

    • Using Pattern Matching to find substring requires ".*" at start and end of
     expression, i.e. Pattern p = Pattern.compile(".*010.*");.

    • str.indexOf(str) returns -1 when string not found.

    • str.indexOf(str) returns index of the 1st char.

    • The following are equivalent:
      str.contains("010")
      str.indexOf("010") != -1

    • Can also use replaceAll() to compute number of occurrences, i.e
      (str.length() - str.replaceAll("010", "").length()) / 3

     */

    static int makeBeautifulBinaryString_1st(int size, String str) {
        String badStr = "010";
        int count = 0;
        while (str.contains("010")) {
            int loc = str.indexOf(badStr);
            str = str.substring(0, loc + 2) + "1" + str.substring(loc + 3);
            count++;
        }
        return (count);
    }

    static int makeBeautifulBinaryString(int size, String str) {
        return ((str.length() - str.replaceAll("010", "").length()) / 3);
    }

    public static void main(String[] args) {

        int actual = 0;

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( makeBeautifulBinaryString(iSize, iString) );

        } else {

            iString = "010010";
            iSize = iString.length();
            if (DEBUG) printData();
            actual = makeBeautifulBinaryString(iSize, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, 2);

            iString = "0101010";
            iSize = iString.length();
            if (DEBUG) printData();
            actual = makeBeautifulBinaryString(iSize, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, 2);

            iString = "01100";
            iSize = iString.length();
            if (DEBUG) printData();
            actual = makeBeautifulBinaryString(iSize, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, 0);

            iString = "0100101010";
            iSize = iString.length();
            if (DEBUG) printData();
            actual = makeBeautifulBinaryString(iSize, iString);
            System.out.println(actual);
            Assert.assertEquals(actual, 3);
        }
    }
}
