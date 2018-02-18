package Algorithms.C01_Warmup.P09_Birthday_Cake_Candles;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static boolean DEBUG = false;
    public static boolean TEST = false;

    static int[] getData() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        in.close();
        return ar;
    }

    static void BirthdayCakeCandles(int[] data) {
        if (DEBUG) System.out.println(Arrays.toString(data));

        int tallestHeight = data[0];
        int tallestCount = 1;

        for (int index = 1; index < data.length ; index++) {
            if (data[index] == tallestHeight) {
                tallestCount += 1;
            } else if (data[index] > tallestHeight) {
                tallestHeight = data[index];
                tallestCount = 1;
            }
        }
        System.out.println(tallestCount);
    }

    public static void main(String[] args) {
        int data[] = {};

        if (!TEST) {
            data = getData();
            BirthdayCakeCandles(data);
        } else {
            /* 1 */ BirthdayCakeCandles(new int[]{1, 2, 3, 4, 5}); // 1

            /* 1 */ BirthdayCakeCandles(new int[]{1}); // 1

            /* 2 */ BirthdayCakeCandles(new int[]{1, 1}); // 2

            /* 3 */ BirthdayCakeCandles(new int[]{1000, 1000, 1000}); // 3

            /* 4 */ BirthdayCakeCandles(new int[]{1, 5, 5, 5, 5}); // 4

            /* 5 */ BirthdayCakeCandles(new int[]{5, 5, 5, 5, 5}); // 5

            /* 3 */ BirthdayCakeCandles(new int[]{7, 20, 33, 77, 77, 77}); // 3

            /* 6 */ BirthdayCakeCandles(new int[]{10000000, 10000000, 10000000, 10000000, 10000000, 10000000}); // 6
        }
    }
}