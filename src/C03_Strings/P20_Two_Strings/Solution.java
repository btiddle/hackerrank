package C03_Strings.P20_Two_Strings;

import java.util.*;
import org.testng.Assert;

class InputData {
    static int iSize;          // input size
    static String[] iStrings;  // input string array

    static void getData() {
        Scanner in = new Scanner(System.in);
        iSize = in.nextInt();
        iStrings = new String[iSize * 2];
        for (int index = 0; index < iSize * 2; index++) {
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

    /*
    See if an anagram of a string is also palindrome

    Two Strings
    https://www.hackerrank.com/challenges/two-strings

    Learning:

    • Using int array to count letters
      int[] chars = new int[26];

    • Using  HashSet<>() to find union
      a.retainAll(b);

    */

    // Using int array
    static String twoStrings_1st(int size, String[] strs) {
        String answer = "";

        for (int index = 0; index < size * 2; index+=2) {
            String str1 = strs[index];
            String str2 = strs[index + 1];

            int[] c1 = new int[26];
            int[] c2 = new int[26];

            boolean found = false;

            // Count characters in str1
            for (int i = 0; i < str1.length(); i++)
                c1[str1.charAt(i) - 'a']++;

            // Count characters in str2
            for (int i = 0; i < str2.length(); i++)
                c2[str2.charAt(i) - 'a']++;

            // Compare character counts between str1 and str2
            for (int i = 0; i < 26; i++){
                if (c1[i] > 0 && c2[i] > 0) {
                    found = true;
                    break;
                }
            }
            answer += found ? "YES\n" : "NO\n";
        }
        return (answer);
    }

    // Using HashSet
    static String twoStrings(int size, String[] strs) {
        Set<Character> a;
        Set<Character> b;
        String answer = "";

        for (int index = 0; index < size * 2; index += 2) {
            String str1 = strs[index];
            String str2 = strs[index + 1];

            a = new HashSet<Character>();
            b = new HashSet<Character>();

            for (char c : str1.toCharArray()) {
                a.add(c);
            }
            for (char c : str2.toCharArray()) {
                b.add(c);
            }

            // store the set intersection in set 'a'
            a.retainAll(b);

            answer += a.isEmpty() ? "NO\n" : "YES\n";
        }
        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( twoStrings(iSize, iStrings) );

        } else {

            iStrings = new String[] {"hello", "world", "hi", "world"};
            iSize = iStrings.length / 2;
            if (DEBUG) printData();
            actual = twoStrings(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES\nNO\n");
        }
    }
}