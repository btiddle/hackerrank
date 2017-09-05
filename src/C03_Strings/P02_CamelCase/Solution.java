package C03_Strings.P02_CamelCase;

import java.util.*;

class InputData {
    static String string;       // input string

    static void getData() {
        Scanner in = new Scanner(System.in);
        string = in.next();
        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "string: " + string + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static int camelCase(String str) {
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z')
                count = count + 1;
        }
        return (count);
    }

    /*

    >>>
    >>> Alternate solution #1: Using regex
    >>>

    Use a regex matching to split the string on capital letters the resulting
    array contains contiguous sections of lowercase letters this works because
    the problem states that each word has at least 2 characters, and we know
    that the first character of each word is always capitalized.

    String[] words = str.split("[A-Z]");
    return (words.length);

    >>>
    >>> Alternate solution #2: Using replace() method
    >>>

    return (str.length() - str.replaceAll("[A-Z]", "").length() + 1);

    >>>
    >>> Alternate solution #3: Using Java8 Streams.
    >>>

    return (str.chars().filter(c -> Character.isUpperCase((char)c)).count()+1);

    */

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( camelCase(string) );  //

        } else {

            string = "a  b c";
            if (DEBUG) printData();
            System.out.println( camelCase(string) );  // 1


            string = "save";
            if (DEBUG) printData();
            System.out.println( camelCase(string) );  // 1

            string = "saveAn";
            if (DEBUG) printData();
            System.out.println( camelCase(string) );  // 2

            string = "saveABee";
            if (DEBUG) printData();
            System.out.println( camelCase(string) );  // 3

            string = "saveChanges";
            if (DEBUG) printData();
            System.out.println( camelCase(string) );  // 2

            string = "saveChangesInTheEditor";
            if (DEBUG) printData();
            System.out.println( camelCase(string) );  // 5
        }
    }
}
