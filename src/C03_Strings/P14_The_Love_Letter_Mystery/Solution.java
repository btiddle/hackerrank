package C03_Strings.P14_The_Love_Letter_Mystery;

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
    static boolean DEBUG = true;
    static boolean TEST = true;

    static String minimumOperations_1st(String[] strs) {

        String answer = "";

        for (String str : strs) {
            int front = 0;
            int back = str.length() - 1;
            int operations = 0;

            for (int i = 0; i < str.length() / 2; i++) {
                    if (str.charAt(front) > str.charAt(back)) {
                        operations += str.charAt(front) - str.charAt(back);
                    } else if (str.charAt(front) < str.charAt(back)) {
                        operations += str.charAt(back) - str.charAt(front);
                    } else {
                        // no operations needed
                    }
                    front++;
                    back--;
            }
            answer += answer.isEmpty() ? operations : "\n" + operations;
        }
        return (answer);
    }

    static String minimumOperations(String[] strs) {
        String answer = "";

        for (String str : strs) {
            int count = 0;
            for (int i = 0; i < str.length() / 2; i++) {
                count += Math.abs(str.charAt(i) - str.charAt(str.length() - 1 - i));
            }
            answer += answer.isEmpty() ? count : "\n" + count;
        }
        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( minimumOperations(iStrings) );

        } else {

            iStrings = new String[] { "abcd"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = minimumOperations(iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "4");

            iStrings = new String[] { "abc", "abcba", "abcd", "cba" };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = minimumOperations(iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "2\n0\n4\n2");
        }
    }
}
