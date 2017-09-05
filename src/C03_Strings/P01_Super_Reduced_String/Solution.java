package C03_Strings.P01_Super_Reduced_String;

import java.util.*;

class InputData {
    static String string;    // string

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
    static boolean DEBUG = false;
    static boolean TEST = false;

    static String super_reduced_string_1st(String string) {

        // Benjamin's 1st solution using StringBuilder

        StringBuilder sb = new StringBuilder(string);

        int current = 0;
        int next = 1;

        restart: do {
            if (sb == null || sb.length() == 0) {
                return ("Empty String");
            }

            if (sb.length() == 1) {
                break;
            }

            if (sb.charAt(current) == sb.charAt(next)) {
                sb.delete(current, current + 2);
                if (sb.length() == 0) {
                    return ("Empty String");
                }
                current = 0;
                next = 1;
                continue restart;

            } else {
                current = current + 1;
                next = next + 1;
            }

        } while ( next < sb.length() );

        return (sb.toString());
    }

    static String super_reduced_string_2nd(String string) {

        // Benjamin's 2nd solution using ArrayDeque

        if (string == null || string.length() == 0) {
            return ("Empty String");
        }

        ArrayDeque data = new ArrayDeque();

        for (int i = 0; i < string.length(); i++) {
            if (!data.isEmpty() && (char) data.peek() == string.charAt(i)) {
                data.pop();
            } else {
                data.push(string.charAt(i));
            }
        }

        if (data.size() == 0) {
            return ("Empty String");
        } else {
            String str = "";
            for (Object s : data) {
                str = s + str;
            }
            return (str);
        }
    }

    static String super_reduced_string(String string) {

        // Hackerrank more elegant solution.
        // Although, it doesn't handle null value, but still passes submission.

        StringBuffer s = new StringBuffer(string);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                s.delete(i-1, i+1);
                i = 0;
            }
        }
        if (s.length() == 0)
            return("Empty String");
        else
            return (s.toString());
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  //

        } else {

            string = "";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // Empty String

            string = null;
            if (DEBUG) printData();
          //System.out.println(super_reduced_string(string));  // Empty String

            string = "aa";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // Empty String

            string = "baab";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // Empty String

            string = "baabcc";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // Empty String

            string = "a";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // a

            string = "ab";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // ab

            string = "abczz";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // abc

            string = "abcabc";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // abc

            string = "abbacddcz";
            if (DEBUG) printData();
            System.out.println(super_reduced_string(string));  // z

        }
    }
}
