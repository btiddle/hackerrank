package C02_Implementation.P02_Apple_and_Orange;

import java.util.*;

class InputData {
    int houseLeft;      // s
    int houseRight;     // t
    int appleTree;      // a
    int orangeTree;     // b
    int applesCount;    // m
    int orangeCount;    // n
    int[] apples;
    int[] oranges;

    public String toString() {
        String str = "";
        str += "houseLeft:   " + houseLeft + " " +   "houseRight:  " + houseRight + "\n";
        str += "appleTree:   " + appleTree + " " +   "orangeTree:  " + orangeTree + "\n";
        str += "applesCount: " + applesCount + " " + "orangeCount: " + orangeCount + "\n";
        str += "apples:      " + Arrays.toString(apples) + "\n";
        str += "oranges:     " + Arrays.toString(oranges);
        return (str);
    }

    static InputData getData() {
        InputData d = new InputData();
        Scanner in = new Scanner(System.in);
        d.houseLeft = in.nextInt();      // s
        d.houseRight = in.nextInt();     // t
        d.appleTree = in.nextInt();      // a
        d.orangeTree = in.nextInt();     // b
        d.applesCount = in.nextInt();    // m
        d.orangeCount = in.nextInt();    // n

        d.apples = new int[d.applesCount];
        for (int apple_i = 0; apple_i < d.applesCount; apple_i++) {
            d.apples[apple_i] = in.nextInt();
        }

        d.oranges = new int[d.orangeCount];
        for (int orange_i = 0; orange_i < d.orangeCount; orange_i++) {
            d.oranges[orange_i] = in.nextInt();
        }

        in.close();
        return d;
    }
}

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static void ApplAndOrange(InputData d) {
        int fallenFruit;
        int applesOnHouse  = 0;
        int orangesOnHouse = 0;

        for (int distantFallen : d.apples) {
            fallenFruit = d.appleTree + distantFallen;
            if (d.houseLeft <= fallenFruit && fallenFruit <= d.houseRight)
                applesOnHouse += 1;
        }
        for (int distantFallen : d.oranges) {
            fallenFruit = d.orangeTree + distantFallen;
            if (d.houseLeft <= fallenFruit && fallenFruit <= d.houseRight)
                orangesOnHouse += 1;
        }
        System.out.println(applesOnHouse);
        System.out.println(orangesOnHouse);
    }

    public static void main(String[] args) {
        InputData data;

        if (!TEST) {
            data = InputData.getData();
            if (DEBUG) System.out.println(data);
            ApplAndOrange(data);
        } else {
            data = new InputData();

            // 7 11 5 15 3 2 -2 2 1 5 -6
            data.houseLeft   = 7;
            data.houseRight  = 11;
            data.appleTree   = 5;
            data.orangeTree  = 15;
            data.applesCount = 3;
            data.orangeCount = 2;
            data.apples = new int[] { -2, 2, 1};
            data.oranges = new int[] { 5, -6 };
            if (DEBUG) System.out.println(data);
            ApplAndOrange(data);  // 1 1

            // 7 11 5 15 6 6 1 2 3 5 6 7 -9 -8 -7 -5 -4 -3
            data.houseLeft   = 7;
            data.houseRight  = 11;
            data.appleTree   = 5;
            data.orangeTree  = 15;
            data.applesCount = 6;
            data.orangeCount = 6;
            data.apples = new int[] { 1, 2, 3, 5, 6, 7};
            data.oranges = new int[] { -9, -8, -7, -5, -4, -3 };
            if (DEBUG) System.out.println(data);
            ApplAndOrange(data);  // 4 4
        }
    }
}
