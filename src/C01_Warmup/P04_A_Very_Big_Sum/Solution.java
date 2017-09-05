package C01_Warmup.P04_A_Very_Big_Sum;

import java.util.*;

class InputData {
    int size;
    long[] array;

    public String toString() {
        return ( "size:  " + size + "\n" +
                 "array: " + Arrays.toString(array)
        );
    }

    static InputData getData() {
        InputData d = new InputData();
        Scanner in = new Scanner(System.in);
        d.size = in.nextInt();
        d.array = new long[d.size];
        for(int index = 0; index < d.size; index++){
            d.array[index] = in.nextLong();
        }
        in.close();
        return d;
    }
}

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static long AVeryBigSum(InputData data) {
        long result = 0;
        for (long value : data.array) {
            result = result + value;
        }
        return result;
    }

    public static void main(String[] args) {
        InputData data;

        if (!TEST) {
            data = InputData.getData();
            if (DEBUG) System.out.println(data);
            System.out.println(AVeryBigSum(data));
        } else {
            data = new InputData();

            // 5 1000000001 1000000002 1000000003 1000000004 1000000005
            data.size = 5;
            data.array = new long[] {1000000001, 1000000002, 1000000003, 1000000004, 1000000005 };
            if (DEBUG) System.out.println(data);
            System.out.println(AVeryBigSum(data)); // 5000000015

            // 10 0 1 2 3 4 5 6 7 8 9
            data.size = 10;
            data.array = new long[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            if (DEBUG) System.out.println(data);
            System.out.println(AVeryBigSum(data)); // 45
        }
    }
}
