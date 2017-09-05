package C02_Implementation.P08_Migratory_Birds;

import java.util.*;

class InputData {
    static int arraySize;  // array size
    static int[] array;    // the array

    static void getData() {
        Scanner in = new Scanner(System.in);
        arraySize = in.nextInt();
        array = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            array[index] = in.nextInt();
        }
        in.close();
    }

    static void printData() {
        String output = (
                "\n" +
                        "arraySize: " + arraySize + "\n" +
                        "array:     " + Arrays.toString(array) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static int migratoryBirds(int arraySize, int[] types) {
        /*
        Traverse array from start to end (i)
          Increment counter for each bird type
        Traverse count array from start to end (i)
          select highest count with lowest id
         */

        int frequencies[] = new int[6];

        for (int i = 0; i < arraySize; i++) {
            frequencies[types[i]] += 1;
        }

        int answerBirdType = 1;
        int answerBirdCount = frequencies[answerBirdType];
        for (int birdType = 2; birdType < 6; birdType++) {
            if (frequencies[birdType] > answerBirdCount) {
                answerBirdType = birdType;
                answerBirdCount = frequencies[answerBirdType];
            }
        }
        return answerBirdType;
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( migratoryBirds(arraySize, array) );  // 4

        } else {
            // 6 1 4 4 4 5 3
            arraySize = 6;
            array     = new int[] {1, 4, 4, 4, 5, 3};
            if (DEBUG) printData();
            System.out.println( migratoryBirds(arraySize, array) );  // 4

            // 6 2 2 2 3 3 3
            arraySize = 6;
            array     = new int[] {2, 2, 2, 3, 3, 3};
            if (DEBUG) printData();
            System.out.println( migratoryBirds(arraySize, array) );  // 4

            // 10 4 4 4 4 3 3 3 2 2 1
            arraySize = 10;
            array     = new int[] {4, 4, 4, 4, 3, 3, 3, 2, 2, 1};
            if (DEBUG) printData();
            System.out.println( migratoryBirds(arraySize, array) );  // 4

            // 10 3 3 3 4 4 4 4 2 2 1
            arraySize = 10;
            array     = new int[] {3, 3, 3, 4, 4, 4, 4, 2, 2, 1};
            if (DEBUG) printData();
            System.out.println( migratoryBirds(arraySize, array) );  // 4


            // 10 3 3 3 2 2 1 4 4 4 4
            arraySize = 10;
            array     = new int[] {3, 3, 3, 2, 2, 1, 4, 4, 4, 4 };
            if (DEBUG) printData();
            System.out.println( migratoryBirds(arraySize, array) );  // 4

        }
    }
}
