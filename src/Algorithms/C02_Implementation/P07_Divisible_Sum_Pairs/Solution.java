package Algorithms.C02_Implementation.P07_Divisible_Sum_Pairs;

import java.util.*;

class InputData {
    static int arraySize;  // array size
    static int  divisor;   // divisor
    static int[] array;    // array of integers

    static void getData() {
        Scanner in = new Scanner(System.in);
        arraySize = in.nextInt();
        divisor = in.nextInt();
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
            "divisor:   " + divisor + "\n" +
            "array:     " + Arrays.toString(array) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static int divisibleSumPairs(int arraySize, int divisor, int[]array) {
        /*
        Traverse array from start to end (i)
          Traverse from (i + 1) to end (j)
            if ( ai + aj) % divisor == 0  )
              count = count + 1
         */

        int count = 0;
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (DEBUG) System.out.println("i = " + i + " j = " + j + " array[i] + array[j] = " + (array[i] + array[j]));
                if ( ((array[i] + array[j]) % divisor) == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            int result = divisibleSumPairs(arraySize, divisor, array);
            System.out.println(result);

        } else {
            // 6 3 1 3 2 6 1 2
            arraySize = 6;
            divisor   = 3;;
            array     = new int[] {1, 3, 2, 6, 1, 2};
            if (DEBUG) printData();
            System.out.println( divisibleSumPairs(arraySize, divisor, array) );
        }
    }
}
