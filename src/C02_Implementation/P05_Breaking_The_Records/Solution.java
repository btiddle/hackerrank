package C02_Implementation.P05_Breaking_The_Records;

// todo: int[] ( int, int[] )


import java.util.*;

class Data {
    int size;
    int[] array;

    public String toString() {
        return ("size:  " + size + "\n" +
                "array: " + Arrays.toString(array) + "\n"
        );
    }

    public int[] getData() {
        Scanner in = new Scanner(System.in);
        size = in.nextInt();

        array = new int[size];
        for (int index = 0; index < size; index++) {
            array[index] = in.nextInt();
        }
        in.close();
        return array;
    }
}

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static int[] getRecord(int[] gameScore) {
        int lowestScore = gameScore[0];
        int highestScore = gameScore[0];
        int lowestScoreCount = 0;
        int highestScoreCount = 0;

        for (int i = 1; i < gameScore.length; i++) {
            if (gameScore[i] < lowestScore) {
                lowestScore = gameScore[i];
                lowestScoreCount++;
            }
            if (gameScore[i] > highestScore) {
                highestScore = gameScore[i];
                highestScoreCount++;
            }
        }
        return new int[] {highestScoreCount, lowestScoreCount } ;
    }

    static public void printResult(int[] output) {
        String separator = "", delimiter = " ";
        for (int val: output) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Data data = new Data();

        if (!TEST) {
            int[] input = data.getData();
            if (DEBUG) System.out.print(data);
            printResult(getRecord(input));

        } else {
            // 9 10 5 20 20 4 5 2 25 1
            data.size = 9;
            data.array = new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1};
            if (DEBUG) System.out.print(data);
            printResult(getRecord(data.array));  // 2 4

            // 10 3 4 21 36 10 28 35 5 24 42
            data.size = 10;
            data.array = new int[]{3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
            if (DEBUG) System.out.print(data);
            printResult(getRecord(data.array));  // 4 0

            // 1 10
            data.size = 1;
            data.array = new int[]{10};
            if (DEBUG) System.out.print(data);
            printResult(getRecord(data.array)); // 0 0

            // 2 5 10
            data.size = 1;
            data.array = new int[]{5, 10};
            if (DEBUG) System.out.print(data);
            printResult(getRecord(data.array)); // 0 1

            // 2 5 10
            data.size = 1;
            data.array = new int[]{5, 10};
            if (DEBUG) System.out.print(data);
            printResult(getRecord(data.array)); // 1 0
        }
    }
}


