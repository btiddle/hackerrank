package Algorithms.C02_Implementation.P13_Counting_Valleys;

import java.util.*;

class InputData {
    static int numberOfSteps;   // number of steps
    static String steps;        // the set of steps

    static void getData() {
        Scanner in = new Scanner(System.in);
        numberOfSteps = in.nextInt();
        steps = in.next();
        in.close();
    }

    static void printData() {
        String output = (
            "\n" +
            "numberOfSteps: " + numberOfSteps + "\n" +
            "steps:         " + steps + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static int countingValleys(int numberOfSteps, String setOfSteps) {
        int elevation  = 0;
        String topography = "sea";
        char step;
        int mountains = 0;
        int valleys = 0;

        for (int i = 0; i < numberOfSteps; i++) {
            step = setOfSteps.charAt(i);

            elevation = (step == 'U') ? ++elevation : --elevation ;

             if (elevation < 0) {
                 topography = "valley";

             } else if (elevation == 0) {
                 if (topography == "mountain") {
                     mountains++;
                 } else { // (topography == "valley")
                     valleys++;
                 }
                 topography = "sea";

             } else { // (elevation > 0)
                topography = "mountain";
            }
        }
        return (valleys);
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( countingValleys(numberOfSteps, steps) );  //

        } else {
            // 8 UDDDUDUU
            numberOfSteps = 8;
            steps = "UDDDUDUU";
            if (DEBUG) printData();
            System.out.println( countingValleys(numberOfSteps, steps) );  // 3

            // 12 DDUUDDUDUUUD
            numberOfSteps = 12;
            steps = "DDUUDDUDUUUD";
            if (DEBUG) printData();
            System.out.println( countingValleys(numberOfSteps, steps) );  // 3
        }
    }
}
