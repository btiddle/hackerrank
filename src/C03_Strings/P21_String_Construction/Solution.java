package C03_Strings.P21_String_Construction;


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
    Count unique characters

    String Construction
    https://www.hackerrank.com/challenges/string-construction

    Learning:

    • HashSet solution
      for (char c : str.toCharArray()) {
          chars.add(c);
      }

    • Java 8 solution
      for (String str: strs) {
          answer += str.chars().distinct().count() + "\n";
      }

    • Array solution (assumes lower case letters)
      for (int i = 0; i < str.length(); i++) {
          counts[str.charAt(i) - 'a' ] = 1;
      }

    */

    // HashSet solution
    static String stringConstruction_1st(int size, String[] strs) {
        String answer = "";

        for (String str: strs) {
            Set <Character> chars = new HashSet<>();

            for (char c : str.toCharArray()) {
                chars.add(c);
            }
            answer += chars.size() + "\n";
        }
        return (answer);
    }

    // Java 8 solution
    static String stringConstruction_2nd(int size, String[] strs) {
        String answer = "";

        for (String str: strs) {
            answer += str.chars().distinct().count() + "\n";
        }
        return (answer);
    }

    // Array solution (assumes lower case letters)
    static String stringConstruction(int size, String[] strs) {
        String answer = "";

        int total = 0;

        for (String str: strs) {
            int counts[] = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a' ] = 1;
            }
            total = 0;
            for (int count: counts) {
                total += count;
            }
            answer += total + "\n";
        }
        return (answer);
    }
    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( stringConstruction(iSize, iStrings) );

        } else {

            iStrings = new String[] {"abcd", "abab"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = stringConstruction(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "4\n2\n");
        }
    }
}
