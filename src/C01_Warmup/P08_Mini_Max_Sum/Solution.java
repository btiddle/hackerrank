package C01_Warmup.P08_Mini_Max_Sum;

import java.util.Scanner;
import java.util.*;

public class Solution {
    public static boolean DEBUG = false;
    public static boolean TEST = false;

    static int[] getData() {
        Scanner in = new Scanner(System.in);
        int length = 5;
        int[] input = new int[length];
        for (int index = 0; index < length; index++) {
            input[index] = in.nextInt();
        }
        in.close();
        return input;
    }

    static void MiniMaxSum1stSolution(int[] data) {
        Arrays.sort(data);
        long min = (long) data[0] + (long) data[1] + (long) data[2] + (long) data[3];
        long max = (long) data[1] + (long) data[2] + (long) data[3] + (long) data[4];
        System.out.println(min + " " + max);
    }

    static void MiniMaxSum(int[] data) {
        int min = data[0];
        int max = data[0];
        long total = 0;

        for (int index = 0; index < data.length; index++){
            total += data[index];
            if (data[index] < min) min = data[index];
            if (data[index] > max) max = data[index];
        }
        System.out.println( (total - max) + " " + (total - min) );
    }

    public static void main(String[] args) {
        int size[];

        if (!TEST) {
            size = getData();
            MiniMaxSum(size);
        } else {
            MiniMaxSum(new int[]{1, 2, 3, 4, 5});            // 10, 14

            MiniMaxSum(new int[]{5, 4, 3, 2, 1});            // 10, 14

            MiniMaxSum(new int[]{100, 300, 200, 600, 400});  // 1,000 1,500

            MiniMaxSum(new int[]{1, 2, 3, 2, 1});            // 6, 8

            MiniMaxSum(new int[]{2147483643, 2147483644, 2147483645, 2147483646,
                    2147483647});  // 8589934578 8589934582
        }
    }
}