package C03_Strings.P19_Game_of_Thrones_1;

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

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    /*
    Can an anagram of a string also be a palindrome

    Game of Thrones - I
    https://www.hackerrank.com/challenges/game-of-thrones

    Learning:

    • Use int array to count letters
      int[] chars = new int[26];

    • Use Set to track non-letter pairs
      if (set.contains(ch)){
          set.remove(ch);
      } else {
          set.add(ch);
      }
    */

    // Use an int array
    static String gameOfThronesOne(String s) {
        // Use an int array [0..25] to represent chars a..z to store char counts.
        int[] chars = new int[26];

        // Count occurrences of each letter
        for (int j = 0; j < s.length(); j++) {
            chars[s.charAt(j) - 'a']++;
        }

        // - if each letter count % 2 == 0, then YES
        // - if each letter count % 2 == 0, except 1 is count % 2 == 1, then YES
        // - else NO
        int count = 0;

        for (int i = 0; i < 26; i++)
            count += chars[i] % 2;

        return count <= 1 ? "YES\n" : "NO\n";
    }

    // Using a Set
    static String gameOfThronesOne_2nd(String str) {
        Set<Character> set = new HashSet<>();

        for(Character ch : str.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }
        return (set.size() <= 1) ? "YES" : "NO";
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( gameOfThronesOne(iString) );

        } else {

            iString = "aaabbbb";
            if (DEBUG) printData();
            actual = gameOfThronesOne(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES\n");

            iString = "cdefghmnopqrstuvw";
            if (DEBUG) printData();
            actual = gameOfThronesOne(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "NO\n");

            iString = "cdcdcdcdeeeef";
            if (DEBUG) printData();
            actual = gameOfThronesOne(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "YES\n");
        }
    }
}
