package C03_Strings.P18_Making_Anagrams;

import java.util.*;
import org.testng.Assert;

class InputData {
    static String iStr1;    // input string array
    static String iStr2;    // input string array

    static void getData() {
        Scanner in = new Scanner(System.in);
        iStr1 = in.next();
        iStr2 = in.next();

        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "iStr1: " + iStr1 + "\n"
            + "iStr2: " + iStr2 + "\n"
        );
        System.out.print(output);
    }
}

    /*
    Create anagram by deleting characters

    Making Anagrams
    https://www.hackerrank.com/challenges/making-anagrams

    Learning:

    • Use int array to count letters
      int[] chars = new int[26];

    • Two different for loop styles can be used:

      for (int j = 0; j < s1.length(); j++) {
          chars[s1.charAt(j) - 'a']++;

      for (char c1 : s1.toCharArray())
          chars[c1 - 'a']++;

    • Solution:

          count[0] count[1] count[2] count[3] count[4]   ...  count[25]
                 a        b        c        d        e   ...          z
    cde          0        0       +1       +1       +1   ...          0
    abc         -1       -1       -1        0        0   ...          0
            ===================================================================
    Total        -1      -1        0        +1      +1   ...          0

    abs(-1) + abs(-1) + abs(0) + abs(+1) + abs(+1) = 4
    anagram = "a"

          count[0] count[1] count[2] count[3] count[4]   ...  count[25]
                 a        b        c        d        e   ...          z
    abcd        +1       +1       +1       +1        0   ...          0
    abc         -1       -1       -1        0        0   ...          0
            ===================================================================
    Total        0        0        0        1       0    ...          0

    abs(0) + abs(0) + abs(0) + abs(1) + abs(0) = 1
    anagram = "abc"

          count[0] count[1] count[2] count[3] count[4]   ...  count[25]
                 a        b        c        d        e   ...          z
    ab          +1       +1        0        0        0   ...          0
    cd           0        0       -1       -1        0   ...          0
            ===================================================================
    Total       +1       +1       -1       -1        0    ...          0

    abs(+1) + abs(+1) + abs(-1) + abs(-1) + abs(0) = 4
    anagram = ""
    */


public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static String makingAnagrams(String s1, String s2) {
        String answer = "";

        // Use an int array [0..25] to represent chars a..z to store char counts.
        int[] chars = new int[26];

        // For each char in s1, increment chars
        for (int j = 0; j < s1.length(); j++) {
            chars[s1.charAt(j) - 'a']++;
        }

        // For each char in s2, decrement chars
        for (int k = 0; k < s2.length(); k++) {
            chars[s2.charAt(k) - 'a']--;
        }

        // The abs sum of array give total number of chars that don't match
        int sum = 0;
        for (int l = 0; l < 26; l++) {
            sum += Math.abs(chars[l]);
        }

        answer += sum + "\n";

        return (answer);
    }

    static String makingAnagrams_2nd(String s1, String s2) {
        String answer = "";

            // Use an int array [0..25] to represent chars a..z to store char counts.
            int[] chars = new int[26];

            // For each char in s1, increment count
            for (char c1 : s1.toCharArray())
                chars[c1 - 'a']++;

            // For each char in s2, decrement count
            for (char c2 : s2.toCharArray())
                chars[c2 - 'a']++;

            // The abs count of array give total number of chars that don't match
            int count = 0;
            for (int i: chars)
                count += Math.abs(chars[i]);

            answer += count + "\n";

        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( makingAnagrams(iStr1, iStr2) );

        } else {

            iStr1 = "cde";
            iStr2 = "abc";
            if (DEBUG) printData();
            actual = makingAnagrams(iStr1, iStr2);
            System.out.println(actual);
            Assert.assertEquals(actual, "4\n");

            iStr1 = "abcd";
            iStr2 = "abc";
            if (DEBUG) printData();
            actual = makingAnagrams(iStr1, iStr2);
            System.out.println(actual);
            Assert.assertEquals(actual, "1\n");

            iStr1 = "ab";
            iStr2 = "cd";
            if (DEBUG) printData();
            actual = makingAnagrams(iStr1, iStr2);
            System.out.println(actual);
            Assert.assertEquals(actual, "4\n");

        }
    }
}
