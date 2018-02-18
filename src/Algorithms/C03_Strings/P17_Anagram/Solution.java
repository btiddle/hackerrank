package Algorithms.C03_Strings.P17_Anagram;

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

    /*
    How many characters in one string are not in another string.

    Anagram
    https://www.hackerrank.com/challenges/anagram/problem

    Anagram is a word, phrase, or name formed by rearranging the letters of
    another, such as cinema, formed from iceman.

    Learning:

    • Solution: (Using StringBuilder)
      - Split string into 2 equal parts: st1 and st2
      - Traverse str2 one character at a time. For each character:
        - Check str1 for existence and delete one in str1 if it exists.
      - Answer is the length of str1 (after all the deletions).

    • When the problem definition is ambiguous, review the discussion tab for
      clarification.

    • To split a string in two:
      String str1 = s.substring(0, len / 2));
      String str2 = s.substring(len / 2);

    • StringBuilder has methods:
      int indexOf(String) and deleteCharAt(int);

    • When using indexOf(String) and not found, returns -1.

    • Can convert a char into string using concatenation.
      int x = str1.indexOf(str2.charAt(i) + "");

    */

    static String anagram_1st(int size, String[] strs) {
        String answer = "";

        for (String s : strs) {
            int len = s.length();

            if (len % 2 != 0) {
                answer += "-1\n";

            } else {
                StringBuilder str1 = new StringBuilder(s.substring(0, len / 2));
                String str2 = s.substring(len / 2);

                for (int i = 0; i < str2.length(); i++) {
                    int x = str1.indexOf(str2.charAt(i) + "");
                    if (x != -1) str1.deleteCharAt(x);
                }
                answer += str1.length() + "\n";
            }
        }
        return (answer);
    }


    /*

    Weighted Uniform Strings
    - Character's numeric value is uesed as a value from 1..26
    - i.e. weight a = 1, b = 2, ... z = 26
    - where curr = 'a' && curr - 'a' + 1 = 1
    Anagram
    - Character's numeric value is used as an index, from 0..25
    - i.e. count[a = 0] = x, count[b = 1] = y, count[c = 3] = z, ...
    - where curr = 'a' && curr - 'a' == 0

     */

    /*

    How many characters in one string are not in another string.

    Anagram
    https://www.hackerrank.com/challenges/anagram/problem

    Anagram is a word, phrase, or name formed by rearranging the letters of
    another, such as cinema, formed from iceman.

    Learning:

              count[0] count[1] count[2] count[3] count[4]   ...  count[25]
                     a        b        c        d        e   ...          z
        aabc        +2       +1       +1        0        0   ...          0
        abbd        -1       -2        0       -1        0   ...          0
        ===================================================================
        Total        1       -1        1       -1        0   ...          0

        abs(1) + abs(-1) + abs(1) + abs(-1) = 4 / 2 = 2

     */

    static String anagram(int size, String[] strs) {
        String answer = "";

        for (String s : strs) {
            // Use an int array [0..25] to represent chars a..z to store char counts.
            int[] count = new int[26];

            if (s.length() %2 != 0) {
                answer += "-1\n";

            } else {
                // For each char in str1, increment count
                for(int i = 0; i < s.length() / 2; i++){
                    count[s.charAt(i) -'a']++;
                }

                // For each char in str2, decrement count
                for(int i = s.length() / 2; i < s.length(); i++){
                    count[s.charAt(i) - 'a']--;
                }

                // The abs sum of array give total number of chars that don't match
                int sum = 0;
                for(int i = 0; i < 26; i++){
                    sum += Math.abs(count[i]);
                }

                // Divide by 2 to calculate number of characters to change in
                // one string to match the other string.
                answer += sum / 2 + "\n";
            }
        }
        return (answer);
    }

    public static void main(String[] args) {
        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println(anagram(iSize, iStrings));

        } else {

            iStrings = new String[]{"wevtpugbaouwobtuuigslvizvqpxrfwpltlapreqfyowckqwszqguyhppxpielxqekswcwmj"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = anagram(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "18\n");

            iStrings = new String[]{"aaabbb", "ab", "abc", "mnop", "xyyx", "xaxbbbxx"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = anagram(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "3\n1\n-1\n2\n0\n1\n");
        }
    }
}
