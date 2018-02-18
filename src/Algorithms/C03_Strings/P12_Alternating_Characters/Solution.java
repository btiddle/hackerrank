package Algorithms.C03_Strings.P12_Alternating_Characters;

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

    static String minimumDeletions_1st(int size, String[] strs) {
        String answer = "";

        for (String str : strs) {
            char prev = ' ';
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char curr = str.charAt(i);
                if (prev == curr)
                    count = count + 1;
                prev = curr;
            }
            answer += answer.isEmpty() ? count : "\n" + count;
        }
        return (answer);
    }

    static String minimumDeletions(int size, String[] strs) {
        String answer = "";

        for (String str : strs) {
            int deletions = 0;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(i-1)) {
                    deletions++;
                }
            }
            answer += answer.isEmpty() ? deletions : "\n" + deletions;
        }
        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( minimumDeletions(iSize, iStrings) );

        } else {

            iStrings = new String[] { "AAAA", "BBBBB", "ABABABAB", "BABABA", "AAABBB" };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = minimumDeletions(iSize,  iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "3\n4\n0\n0\n4");
        }
    }
}
