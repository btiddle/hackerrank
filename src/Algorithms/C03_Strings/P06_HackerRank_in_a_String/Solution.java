package Algorithms.C03_Strings.P06_HackerRank_in_a_String;

import java.util.*;
import java.util.regex.*;
import org.testng.Assert;

class InputData {
    static int iSize;            // input size
    static String[] iMassage;    // input messages (as strings)

    static void getData() {
        Scanner in = new Scanner(System.in);
        iSize = in.nextInt();
        iMassage = new String[iSize];
        for (int index = 0; index < iSize; index++) {
            iMassage[index] = in.next();
        }

        in.close();
    }

    static void printData() {
        String output = (
            "\n"
             + "iSize:    " + iSize + "\n"
             + "iMassage: " + Arrays.deepToString(iMassage) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static String hackerrankInString_1st(String[] messages) {
        // Traverse messages
        // For each message
        //   Traverse message
        //   Traverse pattern
        //   And compare both to each other

        String pattern = "hackerrank";
        String answer = "";

        for (String message : messages) {
            int pIndex = 0;

            for (int mIndex = 0; mIndex < message.length(); mIndex++) {
                if (message.charAt(mIndex) == pattern.charAt(pIndex) ) {
                    pIndex = pIndex + 1;
                    if (pIndex == pattern.length())
                        break;
                }
            }

            if (pIndex == pattern.length())
                answer += answer.isEmpty() ? "YES" : "\nYES";
            else
                answer += answer.isEmpty() ? "NO" : "\nNO";
        }
        return (answer);
    }

    static String hackerrankInString(String[] messages) {
        Pattern p = Pattern.compile(".*h.*a.*c.*k.*e.*r.*r.*a.*n.*k.*");
        String answer = "";

        for (String message : messages) {

            // Check if string contains 'hackerrank' with
            // 0 or more other chars spaced around each char
            Matcher m = p.matcher(message);

            if (m.matches())
                answer += answer.isEmpty() ? "YES" : "\nYES";
            else
                answer += answer.isEmpty() ? "NO" : "\nNO";
        }
        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( hackerrankInString(iMassage) );

        } else {

            iSize = 2;
            iMassage = new String[] {"hereiamstackerrank", "hackerworld"};
            if (DEBUG) printData();
            actual = hackerrankInString(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES\nNO");

            iSize = 2;
            iMassage = new String[] {"hackerrank", "hackerrank"};
            if (DEBUG) printData();
            actual = hackerrankInString(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES\nYES");

            iSize = 2;
            iMassage = new String[] {"hackerran", "hackerran"};
            if (DEBUG) printData();
            actual = hackerrankInString(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, "NO\nNO");

            iSize = 3;
            iMassage = new String[] {"hackerran", "hackerran", "abcdefg"};
            if (DEBUG) printData();
            actual = hackerrankInString(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, "NO\nNO\nNO");
        }
    }
}
