package C03_Strings.P04_Caesar_Cipher_02;

import java.util.Scanner;

import org.testng.Assert;

class InputData {
    static int iSize;          // input size
    static String iString;         // input string
    static int iKey;           // input encryption iKey

    static void getData() {
        Scanner in = new Scanner(System.in);
        iSize = in.nextInt();
        iString = in.next();
        iKey = in.nextInt();

        in.close();
    }

    static void printData() {
        String output = (
                "\n"
                        + "iSize:    " + iSize + "\n"
                        + "iMassage: " + iString + "\n"
                        + "iKey:     " + iKey + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    private static String caesarCipher(int length, String str, int key) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            sb.append(encrypt(ch, key));
        }
        return (sb.toString());
    }

    /* Encrypts a character using Caesar Cipher */
    private static char encrypt(char ch, int K) {
        if (!Character.isLetter(ch)) {
            return ch;
        }
        char base = Character.isLowerCase(ch) ? 'a' : 'A';
        return (char) ((ch - base + K) % 26 + base);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( caesarCipher(iSize, iString, iKey) );

        } else {

            iSize = 1;
            iString = "z";
            iKey = 2;
            if (DEBUG) printData();
            actual = caesarCipher(iSize, iString, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "b");

            iSize = 6;
            iString = "XYZABC";
            iKey = 2;
            if (DEBUG) printData();
            actual = caesarCipher(iSize, iString, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "ZABCDE");

            iSize = 2;
            iString = "ab";
            iKey = 2;
            if (DEBUG) printData();
            actual = caesarCipher(iSize, iString, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "cd");

            iSize = 11;
            iString = "middle-Outz";
            iKey = 2;
            if (DEBUG) printData();
            actual = caesarCipher(iSize, iString, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "okffng-Qwvb");

            iSize = 3;
            iString = "abc";
            iKey = 52;
            if (DEBUG) printData();
            actual = caesarCipher(iSize, iString, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "abc");

            iSize = 3;
            iString = "XYZ";
            iKey = 520;
            if (DEBUG) printData();
            actual = caesarCipher(iSize, iString, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "XYZ");

            iSize = 3;
            iString = "XYZ";
            iKey = 0;
            if (DEBUG) printData();
            actual = caesarCipher(iSize, iString, iKey);
            System.out.println(actual);
            Assert.assertEquals(actual, "XYZ");
        }
    }
}
