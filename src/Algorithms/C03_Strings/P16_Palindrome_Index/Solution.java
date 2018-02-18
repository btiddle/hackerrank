package Algorithms.C03_Strings.P16_Palindrome_Index;


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

    static boolean isPalindrome(String str) {
        boolean palindrome = false;
        int len = str.length();

        int remainder = len % 2;
        String firstHalf = str.substring(0, len/2);
        String temp = str.substring(len/2 + remainder);
        String secondHalf = new StringBuffer(temp).reverse().toString();

        if (firstHalf.equals(secondHalf)) {
            palindrome = true;
        }
        return (palindrome);
    }

    static String palindromeIndex(int size, String[] strs) {
        String answer = "";

        for (String str : strs) {
            StringBuilder sbStr;
            int index = -1;

            if (isPalindrome(str)) {
                answer += "-1\n";
                continue;
            }

            found:
            for (int i = 0; i < str.length(); i++) {
                index = -1;
                sbStr = new StringBuilder(str);
                sbStr.deleteCharAt(i);
                if (isPalindrome(sbStr.toString())) {
                    index = i;
                    break found;
                }
            }
            answer += index == -1 ? "-1\n" : Integer.toString(index) + "\n";
        }
        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( palindromeIndex(iSize, iStrings) );

        } else {
            isPalindrome("aaab");
            isPalindrome("baa");
            isPalindrome("aaa");


            iStrings = new String[] {"aaab", "baa", "aaa"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = palindromeIndex(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "3\n0\n-1\n");
        }
    }
}
