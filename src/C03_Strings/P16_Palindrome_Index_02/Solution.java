package C03_Strings.P16_Palindrome_Index_02;

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

    /*
    Find the "one" character to delete to create Palindrome.

    Palindrome Index
    https://www.hackerrank.com/challenges/palindrome-index/problem

    Given a string S of lowercase letters, determine the index of the character
    whose removal will make a palindrome. There is always a solution.

    Learning:

    • Traverse from both ends (start, end) to middle. When a char doesn't match,
      check next two characters beyond start. If they pass, then delete start
      char, else delete end character (because solution is always present). Two
      character check is required because must handle even and odd palindrome
      character size.

    • Solution intended working string "in place." Using additional
      StringBugger() resulted in some test cases timing out on website, even
      though passing locally (although, after long time).
    */


    static int palindromeIndex(String str) {
        int len = str.length();
        int start = 0, end = len - 1;
        while (start < end) {

            System.out.println(
                "start     " +
                "start + 1 " +
                "start + 2 " +
                "end - 2   " +
                "end - 1   " +
                "end       "
            );
            System.out.println(String.format("%-9c %-9c %-9c %-9c %-9c %-9c ",
                (char) str.charAt(start),
                (char) str.charAt(start+1),
                (char) str.charAt(start+2),
                (char) str.charAt(end-2),
                (char) str.charAt(end-1),
                (char) str.charAt(end))
            );

            if (str.charAt(start) != str.charAt(end)) {
                if ((str.charAt(start + 1) == str.charAt(end)) &&
                    (str.charAt(start + 2) == str.charAt(end - 1)))
                    return start;
                else
                    return end;
            }
            start++;
            end--;
        }
        return -1;
    }


    static int palindromeIndex_1st(String str) {
        int len = str.length();
        int start = 0, end = len - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                if ((str.charAt(start + 1) == str.charAt(end)) &&
                    (str.charAt(start + 2) == str.charAt(end - 1)))
                    return start;
                else
                    return end;
            }
            start++;
            end--;
        }
        return -1;
    }

    static int palindromeIndex_2nd(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                if (str.charAt(i + 1) != str.charAt(j))
                    return j;
                else if (str.charAt(i) != str.charAt(j - 1))
                    return i;
                else {
                    if (str.charAt(i + 2) != str.charAt(j - 1))
                        return j;
                    if (str.charAt(i + 1) != str.charAt(j - 2))
                        return i;
                }
            }
        }
        return (-1);
    }

    static String solution(int size, String[] strs){
        String answer = "";
        for (String str : strs) {
            answer += palindromeIndex(str) + "\n";
        }
        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( solution(iSize, iStrings) );

        } else {

            iStrings = new String[] {"aaab", "baa", "aaa"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solution(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "3\n0\n-1\n");

            iStrings = new String[] {"abczddcba"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solution(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "3\n");

            iStrings = new String[] {"abcddzcba"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solution(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "5\n");
        }
    }
}
