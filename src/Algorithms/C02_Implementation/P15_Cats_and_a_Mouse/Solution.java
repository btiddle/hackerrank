package Algorithms.C02_Implementation.P15_Cats_and_a_Mouse;

import java.util.*;

class InputData {
    static int numberOfQueries;  // queries size

    static int arraySize;
    static int[] queries;

    static void getData() {
        Scanner in = new Scanner(System.in);
        numberOfQueries = in.nextInt();
        arraySize = numberOfQueries * 3;
        queries = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            queries[index] = in.nextInt();
        }
        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "numberOfQueries: " + numberOfQueries + "\n"
            + "queries:         " + queries[0] + " " + queries[1] + " " + queries[2] + "\n"
        );

        System.out.print(output);
        for (int i = 3; i < queries.length; i = i + 3) {
            System.out.println("                 " + queries[i] + " " + queries[i + 1] + " " + queries[i + 2]);
        }
    }
}

public class Solution extends InputData {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static void catsAndAMouse(int numberOfQueries, int[] queries) {
        int catA;
        int catB;
        int mouseC;
        int catADistance;
        int catBDistance;
        String result = "";

        for (int i = 0; i < queries.length; i = i + 3) {
            catA = queries[i];                 // cat A location
            catB = queries[i + 1];             // cat B location
            mouseC = queries[i + 2];           // mouse C location
            catADistance = Math.abs(catA - mouseC);
            catBDistance = Math.abs(catB - mouseC);
            if (catADistance < catBDistance) {
                result = "Cat A";
            } else if (catBDistance < catADistance){
                result = "Cat B";
            } else {
                result = "Mouse C";
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            catsAndAMouse(numberOfQueries, queries);  //

        } else {
            // 3 1 2 3 1 3 2 2 1 3
            numberOfQueries = 3;
            queries = new int[] {1, 2, 3, 1, 3, 2, 2, 1, 3};
            if (DEBUG) printData();
            catsAndAMouse(numberOfQueries, queries);  //
        }
    }
}
