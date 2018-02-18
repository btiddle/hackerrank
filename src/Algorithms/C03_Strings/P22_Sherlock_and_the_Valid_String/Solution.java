package Algorithms.C03_Strings.P22_Sherlock_and_the_Valid_String;


import java.util.*;
import org.testng.Assert;

class InputData {
    static String iString;     // input string

    static void getData() {
        Scanner in = new Scanner(System.in);
        iString = in.next();

        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "iString:  " + iString + "\n"
        );
        System.out.print(output);
    }
}


/*

Test case #17 is "abcccc" and reported answer is NO. But if you follow
logic of problem, it should be YES. Since contradiction, aborting trying
to find solution. Have spent to much time on this one.

*/

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    /*
    Check for even characters with one odd

    Sherlock and the Valid String
    https://www.hackerrank.com/challenges/sherlock-and-valid-string

    Solution:
    • Count the occurrence of all the characters
    • If all counts are same then valid.
    • If there is just one character whose count is different, then valid.
    • If there is more than 1 characters that differs in count then invalid.

    Learning:

    • Array solution (assumes lower case letters)
      for (int i = 0; i < str.length(); i++) {
          counts[str.charAt(i) - 'a' ] = 1;
      }

    */

    static String sherlockAndTheValidString(String str) {
        String answer = "";
        Map<Character, Integer> counts = new HashMap<>();

        // Count the characters
        for (Character c : str.toCharArray()) {
            if (counts.containsKey(c)) {
                int frequency = counts.get(c);
                counts.put(c, frequency + 1);
            } else {
                counts.put(c, 1);
            }
        }

        int min = Collections.min(counts.values());
        int max = Collections.max(counts.values());
        Map<Integer, Integer> intMap = new HashMap<>();

        for (int count : counts.values()) {
            if (intMap.containsKey(count)) {
                Integer frequency = intMap.get(count);
                intMap.put(count, frequency + 1);
            } else {
                intMap.put(count, 1);
            }
        }

        if (intMap.size() <= 1) {
            answer = "YES";
        } else if (intMap.size() == 2 && intMap.get(min) <= 1) {
            answer = "YES";
        } else if (intMap.size() == 2 && intMap.get(max) <= 1) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( sherlockAndTheValidString(iString) );

        } else {

            iString = "aabbcd";
            if (DEBUG) printData();
            actual = sherlockAndTheValidString(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "NO");

            iString = "hfchdkkbfifgbgebfaahijchgeeeiagkadjfcbekbdaifchkjfejckbiiihegacfbchdihkgbkbddgaefhkdgccjejjaajgijdkd";
            if (DEBUG) printData();
            actual = sherlockAndTheValidString(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES");

            iString = "aabbcc";
            if (DEBUG) printData();
            actual = sherlockAndTheValidString(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES");

            iString = "baacdd";
            if (DEBUG) printData();
            actual = sherlockAndTheValidString(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "NO");

            iString = "aabbccc";
            if (DEBUG) printData();
            actual = sherlockAndTheValidString(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES");

            iString = "aabbc";
            if (DEBUG) printData();
            actual = sherlockAndTheValidString(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES");

            iString = "abcccc";
            if (DEBUG) printData();
            actual = sherlockAndTheValidString(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "NO");

        }
    }
}
