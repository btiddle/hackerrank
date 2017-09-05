package C01_Warmup.P06_Plus_Minus;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // 6 -4 3 -9 0 4 1

        double negativeNum = 0;
        double zeroNum = 0;
        double positiveNum= 0;

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] intArray = new int[length];
        for (int index = 0; index < length; index++) {
            intArray[index] = in.nextInt();
            if (intArray[index] <  0) negativeNum += 1.0;
            if (intArray[index] == 0) zeroNum     += 1.0;
            if (intArray[index] >  0) positiveNum += 1.0;
        }
        System.out.format("%.6f%n", positiveNum/length );
        System.out.format("%.6f%n", negativeNum/length );
        System.out.format("%.6f%n", zeroNum/length );
    }
}

