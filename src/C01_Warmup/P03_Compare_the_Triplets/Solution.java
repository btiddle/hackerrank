package C01_Warmup.P03_Compare_the_Triplets;

import java.util.*;

class InputData {
    int a0;
    int a1;
    int a2;
    int b0;
    int b1;
    int b2;

    public String toString() {
        return ("a0: " + a0 + "\n" +
                "a1: " + a1 + "\n" +
                "a2: " + a2 + "\n" +
                "b0: " + b0 + "\n" +
                "b1: " + b1 + "\n" +
                "b2: " + b2
        );
    }

    static InputData getData() {
        InputData d = new InputData();
        Scanner in = new Scanner(System.in);
        d.a0 = in.nextInt();
        d.a1 = in.nextInt();
        d.a2 = in.nextInt();
        d.b0 = in.nextInt();
        d.b1 = in.nextInt();
        d.b2 = in.nextInt();

        in.close();
        return d;
    }
}

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static void CompareTheTriplets(InputData d) {
        int[] result = {0, 0};

        if (d.a0 > d.b0) result[0] += 1;
        if (d.a0 < d.b0) result[1] += 1;

        if (d.a1 > d.b1) result[0] += 1;
        if (d.a1 < d.b1) result[1] += 1;

        if (d.a2 > d.b2) result[0] += 1;
        if (d.a2 < d.b2) result[1] += 1;

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        InputData data;

        if (!TEST) {
            data = InputData.getData();
            if (DEBUG) System.out.println(data);
            CompareTheTriplets(data);
        } else {
            data = new InputData();

            // 5 6 7 3 6 10
            data.a0 = 5;
            data.a1 = 6;
            data.a2 = 7;
            data.b0 = 3;
            data.b1 = 6;
            data.b2 = 10;
            if (DEBUG) System.out.println(data);
            CompareTheTriplets(data); // 11

            // 0 0 0 0 0  0
            data.a0 = 0;
            data.a1 = 0;
            data.a2 = 0;
            data.b0 = 0;
            data.b1 = 0;
            data.b2 = 0;
            if (DEBUG) System.out.println(data);
            CompareTheTriplets(data); // 0 0

            // 1 1 1 0 0  0
            data.a0 = 1;
            data.a1 = 1;
            data.a2 = 1;
            data.b0 = 0;
            data.b1 = 0;
            data.b2 = 0;
            if (DEBUG) System.out.println(data);
            CompareTheTriplets(data); // 3 0

            // 0 0  0 1 1 1
            data.a0 = 0;
            data.a1 = 0;
            data.a2 = 0;
            data.b0 = 1;
            data.b1 = 1;
            data.b2 = 1;
            if (DEBUG) System.out.println(data);
            CompareTheTriplets(data); // 0 3

            // 1 0 1 0 0 0)
            data.a0 = 1;
            data.a1 = 0;
            data.a2 = 1;
            data.b0 = 0;
            data.b1 = 0;
            data.b2 = 0;
            if (DEBUG) System.out.println(data);
            CompareTheTriplets(data); // 2 0

            // 0 0 0 1 0 1
            data.a0 = 0;
            data.a1 = 0;
            data.a2 = 0;
            data.b0 = 1;
            data.b1 = 0;
            data.b2 = 1;
            if (DEBUG) System.out.println(data);
            CompareTheTriplets(data); // 0 2

            // 10 20 30 9 21, 31
            data.a0 = 10;
            data.a1 = 20;
            data.a2 = 30;
            data.b0 = 9;
            data.b1 = 21;
            data.b2 = 31;
            if (DEBUG) System.out.println(data);
            CompareTheTriplets(data); // 1 2
        }
    }
}
