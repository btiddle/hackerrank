package C02_Implementation.P03_Kangaro;

import java.util.*;

class InputData {
    int x1;
    int v1;
    int x2;
    int v2;

    public String toString() {
        return (
            "x1:  " + x1 + "\n" +
            "v1:  " + v1 + "\n" +
            "x2:  " + x2 + "\n" +
            "v2:  " + v2
        );
    }

    static InputData getData() {
        InputData d = new InputData();
        Scanner in = new Scanner(System.in);
        d.x1 = in.nextInt();
        d.v1 = in.nextInt();
        d.x2 = in.nextInt();
        d.v2 = in.nextInt();

        in.close();
        return d;
    }
}

public class Solution {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static String Kangaroo(InputData d) {
        boolean sameLocation = false;

        do {
            //if (DEBUG) System.out.println(d);
            if (d.x1 == d.x2) {
                sameLocation = true;
                break;
            } else {
                d.x1 += d.v1;
                d.x2 += d.v2;
            }
        } while (d.x1 <= Integer.MAX_VALUE &&
                d.x2 <= Integer.MAX_VALUE &&
                d.x1 > 0 &&
                d.x2 > 0);
        return (sameLocation? "YES" : "NO");
    }

    public static void main(String[] args) {
        InputData data;

        if (!TEST) {
            data = InputData.getData();
            if (DEBUG) System.out.println(data);
            System.out.println(Kangaroo(data));
        } else {
            data = new InputData();

            // 0 3 4 2
            data.x1  = 0;
            data.v1  = 3;
            data.x2  = 4;
            data.v2  = 2;
            if (DEBUG) System.out.println(data);
            System.out.println(Kangaroo(data));  // YES

            // 0 2 5 3
            data.x1  = 0;
            data.v1  = 2;
            data.x2  = 5;
            data.v2  = 3;
            if (DEBUG) System.out.println(data);
            System.out.println(Kangaroo(data));  // NO

            // 1 2 2 2
            data.x1  = 1;
            data.v1  = 2;
            data.x2  = 2;
            data.v2  = 2;
            if (DEBUG) System.out.println(data);
            System.out.println(Kangaroo(data));  // NO

            // 1408 6689 6730 4028
            data.x1  = 1408;
            data.v1  = 6689;
            data.x2  = 6730;
            data.v2  = 4028;
            if (DEBUG) System.out.println(data);
            System.out.println(Kangaroo(data));  // YES
        }
    }
}
