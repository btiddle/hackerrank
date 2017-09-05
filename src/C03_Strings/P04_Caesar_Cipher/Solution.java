package C03_Strings.P04_Caesar_Cipher;

import java.util.*;
import org.testng.Assert;

class InputData {
    static int iSize;          // input size
    static char[] iMassage;    // input string (as characters)
    static int iKey;           // input encryption iKey

    static void getData() {
        Scanner in = new Scanner(System.in);
        iSize = in.nextInt();
        iMassage = in.next().toCharArray();
        iKey = in.nextInt();

        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "iSize:    " + iSize + "\n"
            + "iMassage: " + new String(iMassage) + "\n"
            + "iKey:     " + iKey + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static String solve(int size, char[] message, int key) {
        int baseUpper = 'Z';
        int baseLower = 'z';
        int normalizedKey = key % 26;
        int letter;

        for (int i = 0; i < size; i++) {
            letter = message[i];
            if (Character.toString(message[i]).matches("[A-Z]")) {
                letter = message[i] + normalizedKey;
                if (letter > baseUpper)
                    letter = letter - 26;
                message[i] = (char) letter;
            } else if (Character.toString(message[i]).matches("[a-z]")) {
                letter = message[i] + normalizedKey;
                if (letter > baseLower)
                    letter = letter - 26;
                message[i] = (char) letter;
            }
        }
        return (new String(message));
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( solve(iSize, iMassage, iKey) );

        } else {

            iSize = 1;
            iMassage = "z".toCharArray();
            iKey = 2;
            if (DEBUG) printData();
            actual = solve(iSize, iMassage, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "b");

            iSize = 6;
            iMassage = "XYZABC".toCharArray();
            iKey = 2;
            if (DEBUG) printData();
            actual = solve(iSize, iMassage, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "ZABCDE");

            iSize = 2;
            iMassage = "ab".toCharArray();
            iKey = 2;
            if (DEBUG) printData();
            actual = solve(iSize, iMassage, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "cd");

            iSize = 11;
            iMassage = "middle-Outz".toCharArray();
            iKey = 2;
            if (DEBUG) printData();
            actual = solve(iSize, iMassage, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "okffng-Qwvb");

            iSize = 3;
            iMassage = "abc".toCharArray();
            iKey = 52;
            if (DEBUG) printData();
            actual = solve(iSize, iMassage, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "abc");

            iSize = 3;
            iMassage = "XYZ".toCharArray();
            iKey = 520;
            if (DEBUG) printData();
            actual = solve(iSize, iMassage, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "XYZ");

            iSize = 3;
            iMassage = "XYZ".toCharArray();
            iKey = 0;
            if (DEBUG) printData();
            actual = solve(iSize, iMassage, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "XYZ");
        }
    }
}
