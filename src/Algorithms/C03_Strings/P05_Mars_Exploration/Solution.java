package Algorithms.C03_Strings.P05_Mars_Exploration;

import java.util.*;
import org.testng.Assert;

class InputData {
    static char[] iMassage;    // input string (as characters)

    static void getData() {
        Scanner in = new Scanner(System.in);
        iMassage = in.next().toCharArray();

        in.close();
    }

    static void printData() {
        String output = (
            "\n"
             + "iMassage: " + new String(iMassage) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static int alteredLetters_1st(char[] message) {
        int error = 0;

        for (int i = 0; i < message.length; i = i + 3) {
            if (message[i] != 'S') error++;
            if (message[i + 1] != 'O') error++;
            if (message[i + 2] != 'S') error++;
        }
        return (error);
    }

    static int alteredLetters(char[] message) {
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < message.length; i++) {
            if (message[i] != sos.charAt(i % 3)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

      int actual;

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( alteredLetters(iMassage) );

        } else {

            iMassage = "SOS".toCharArray();
            if (DEBUG) printData();
            actual = alteredLetters(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, 0);

            iMassage = "AOS".toCharArray();
            if (DEBUG) printData();
            actual = alteredLetters(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, 1);

            iMassage = "ABS".toCharArray();
            if (DEBUG) printData();
            actual = alteredLetters(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, 2);

            iMassage = "ABC".toCharArray();
            if (DEBUG) printData();
            actual = alteredLetters(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, 3);

            iMassage = "SOSSPSSQSSOR".toCharArray();
            if (DEBUG) printData();
            actual = alteredLetters(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, 3);

            iMassage = "SOSSOT".toCharArray();
            if (DEBUG) printData();
            actual = alteredLetters(iMassage);
            System.out.println(actual);
            Assert.assertEquals(actual, 1);
        }
    }
}
