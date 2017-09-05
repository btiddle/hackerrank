package C02_Implementation.P04_Between_Two_Sets;

import java.util.*;

class InputData {
    int aSize;     // n
    int bSize;     // m
    int[] aArray;  // a[]
    int[] bArray;  // b[]

    public String toString() {
        return ("aSize: " + aSize + "\n" +
                "bSize: " + bSize + "\n" +
                "aArray: " + Arrays.toString(aArray) + "\n" +
                "bArray: " + Arrays.toString(bArray) + "\n"
        );
    }

    static InputData getData() {
        InputData d = new InputData();
        Scanner in = new Scanner(System.in);
        d.aSize = in.nextInt();
        d.bSize = in.nextInt();

        d.aArray = new int[d.aSize];
        for (int index = 0; index < d.aSize; index++) {
            d.aArray[index] = in.nextInt();
        }

        d.bArray = new int[d.bSize];
        for (int index = 0; index < d.bSize; index++) {
            d.bArray[index] = in.nextInt();
        }

        in.close();
        return d;
    }
}

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;


    static void BetweenTwoSets(InputData d) {
        int max = d.aArray[0];
        int count = 0;

        for (int value : d.aArray) {
            if (max < value) max = value;
        }
        for (int value : d.bArray) {
            if (max < value) max = value;
        }

        between: for (int x = 1; x <= max; x++) {
            for (int a : d.aArray) {
                if (x % a ==  0) {
                    for (int b : d.bArray) {
                        if (b % x == 0) {
                            // So far so good.
                        } else {
                            continue between;
                        }
                    }
                } else {
                    continue between;
                }
            }
            if (DEBUG) System.out.print( x + " ");
            count += 1;
        }
        if (DEBUG) System.out.println();
        System.out.println(count);
    }

    public static void main(String[] args) {
        InputData data;

        if (!TEST) {
            data = InputData.getData();
            if (DEBUG) System.out.print(data);
            BetweenTwoSets(data);
        } else {
            data = new InputData();

            // 2 1 2 6 12
            data.aSize = 2;
            data.bSize = 1;
            data.aArray = new int[]{2, 6};
            data.bArray = new int[]{12};
            if (DEBUG) System.out.print(data);
            BetweenTwoSets(data);  // 2

            // 2 3 2 4 16 32 96
            data.aSize = 2;
            data.bSize = 3;
            data.aArray = new int[]{2, 4};
            data.bArray = new int[]{16, 32, 96};
            if (DEBUG) System.out.print(data);
            BetweenTwoSets(data);  // 3

            // 1 2 1 72 48
            data.aSize = 1;
            data.bSize = 2;
            data.aArray = new int[]{1};
            data.bArray = new int[]{72, 48};
            if (DEBUG) System.out.print(data);
            BetweenTwoSets(data);  // 8
        }
    }
}
