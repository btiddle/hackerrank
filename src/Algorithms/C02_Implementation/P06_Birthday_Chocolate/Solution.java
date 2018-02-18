package Algorithms.C02_Implementation.P06_Birthday_Chocolate;

import java.util.*;

class InputData {
    static int numValues;
    static int[] values;
    static int birthDay;
    static int birthMonth;

    static void getData() {
        Scanner in = new Scanner(System.in);
        numValues = in.nextInt();
        values = new int[numValues];
        for (int index = 0; index < numValues; index++) {
            values[index] = in.nextInt();
        }
        birthDay = in.nextInt();
        birthMonth = in.nextInt();
        in.close();
    }

    static void printData() {
        String output = (
                "numSquares: " + numValues + "\n" +
                "values:     " + Arrays.toString(values) + "\n" +
                "birthDay:   " + birthDay + "\n" +
                "birthMonth: " + birthMonth + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = false;
    static boolean TEST = true;

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
        return new int[]{highestScoreCount, lowestScoreCount};
    }

    static void birthdayChocolate() {
        /*
        1. Travel array
        2. Add next "month" squares as sum
        3. if sum EQ "day" increment count
           if sum LT "day" keep going
           if sum GT "day" abort current array location
         */

        int count = 0;
        next: for (int x = 0; x < values.length; x++ ) {
            int sum = 0;
            int endpoint = x + birthMonth;
            for (int y = x; (y < values.length && y < endpoint); y++) {
                sum += values[y];
                if (sum == birthDay && y == (endpoint - 1)) {
                    count += 1;
                    continue next;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            birthdayChocolate();

        } else {
            // 5 1 2 1 3 2 3 2
            numValues = 5;
            values = new int[]{1, 2, 1, 3, 2};
            birthDay = 3;
            birthMonth = 2;
            if (DEBUG) printData();
            birthdayChocolate();  // 2

            // 6 1 1 1 1 1 1 3 2
            numValues = 6;
            values = new int[]{1, 1, 1, 1, 1, 1};
            birthDay = 3;
            birthMonth = 2;
            if (DEBUG) printData();
            birthdayChocolate();  // 0

            // 7 1 1 1 1 1 1 1 7 7
            numValues = 7;
            values = new int[]{1, 1, 1, 1, 1, 1, 1};
            birthDay = 7;
            birthMonth = 7;
            if (DEBUG) printData();
            birthdayChocolate();  // 1

            // 8 1 1 1 1 1 1 1 1 7 7
            numValues = 8;
            values = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
            birthDay = 7;
            birthMonth = 7;
            if (DEBUG) printData();
            birthdayChocolate();  // 2

            // 8 1 2 1 2 1 2 1 2    3 2
            numValues = 8;
            values = new int[]{1, 2, 1, 2, 1, 2, 1, 2};
            birthDay = 3;
            birthMonth = 2;
            if (DEBUG) printData();
            birthdayChocolate();  // 7
        }
    }
}
