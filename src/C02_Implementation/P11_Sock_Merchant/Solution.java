package C02_Implementation.P11_Sock_Merchant;

import java.util.*;

class InputData {
    static int arraySize;  // array size
    static int[] array;    // the array

    static void getData() {
        Scanner in = new Scanner(System.in);
        arraySize = in.nextInt();
        array = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            array[index] = in.nextInt();
        }
        in.close();
    }

    static void printData() {
        String output = (
            "\n" +
            "arraySize: " + arraySize + "\n" +
            "array:     " + Arrays.toString(array) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static int sockMerchantFirstAttempt(int arraySize, int[] colors) {
        /*
        - travel array from begin to end
           - store count of each color in new array
        - travel new array from beginning to end
           - pairs = pairs + (array[i] / 2)
         */

        int[] colorCounts = new int[101];
        for (int color : colors ) {
            colorCounts[color] += 1;
        }

        int pairs = 0;
        for (int count : colorCounts) {
            pairs = pairs + (count / 2);
        }

        return pairs;
    }

    static int sockMerchant(int arraySize, int[] array) {
        HashMap <Integer, Integer> colors = new HashMap<Integer, Integer>();

        for (int color : array) {
            Integer frequency = colors.get(color);
            if (frequency == null) {
                colors.put(color, 1);
            } else {
                colors.put(color, frequency + 1);
            }
        }

        int pairs = 0;

        for (Integer frequency : colors.values()) {
            pairs = pairs + (frequency / 2);
        }

        return pairs;
    }


    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( sockMerchant(arraySize, array) );  //

        } else {
            // 9 10 20 20 10 10 30 50 10 20
            arraySize = 9;
            array     = new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20};
            if (DEBUG) printData();
            System.out.println( sockMerchant(arraySize, array) );  // 3

            // 1
            arraySize = 1;
            array     = new int[] {1};
            if (DEBUG) printData();
            System.out.println( sockMerchant(arraySize, array) ); // 0

            arraySize = 1;
            array     = new int[] {100};
            if (DEBUG) printData();
            System.out.println( sockMerchant(arraySize, array) ); // 0

            arraySize = 2;
            array     = new int[] {100, 100, 100, 100};
            if (DEBUG) printData();
            System.out.println( sockMerchant(arraySize, array) ); // 2
        }
    }
}
