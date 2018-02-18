package Algorithms.C01_Warmup.P02_Simple_Array_Sum;

import java.util.*;

class InputData {
    int size;
    int[] array;

    public String toString() {
        return (
            "size:  " + size + "\n" +
            "array: " + Arrays.toString(array) + "\n"
        );
    }

    static InputData getData() {
        InputData d = new InputData();
        Scanner in = new Scanner(System.in);
        d.size = in.nextInt();

        d.array = new int[d.size];
        for (int index = 0; index < d.size; index++) {
            d.array[index] = in.nextInt();
        }

        in.close();
        return d;
    }
}

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static int simpleArraySum(InputData d) {
        boolean conditionOne = true;
        boolean conditionTwo = true;

        int total = 0;
        for (int number : d.array) {
            total = total + number;
        }
        return total;
    }

    public static void main(String[] args) {
        InputData data;

        if (!TEST) {
            data = InputData.getData();
            if (DEBUG) System.out.print(data);
            System.out.println(simpleArraySum(data));
        } else {
            data = new InputData();

            // 6 1 2 3 4 10 11
            data.size  = 6;
            data.array = new int[] { 1, 2, 3, 4, 10, 11};
            if (DEBUG) System.out.print(data);
            System.out.println(simpleArraySum(data));  // 31

            // 1 21000
            data.size  = 1;
            data.array = new int[] { 21000};
            if (DEBUG) System.out.print(data);
            System.out.println(simpleArraySum(data));  // 21000

            // 10 0 0 0 0 0 0 0 0 0 0
            data.size  = 10;
            data.array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            if (DEBUG) System.out.print(data);
            System.out.println(simpleArraySum(data));  // 0

            // 5 -1, -2, -3, -4, -5
            data.size  = 5;
            data.array = new int[] { -1, -2, -3, -4, -5};
            if (DEBUG) System.out.print(data);
            System.out.println(simpleArraySum(data));  // -15
        }
    }
}
