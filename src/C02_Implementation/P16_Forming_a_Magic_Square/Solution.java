package C02_Implementation.P16_Forming_a_Magic_Square;

import java.util.*;

class InputData {
    static int[][] intArray;   // int intArray

    static void getData() {
        Scanner in = new Scanner(System.in);
        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "intArray:  " + Arrays.toString(intArray) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static int magicSquare(int[][] matrix) {
        int sumTarget = 15; // sum(1 .. 9) = 45; 45 / 3 = 15

        int row1 = matrix[0][0] + matrix[0][1] + matrix[0][2];
        int row2 = matrix[1][0] + matrix[1][1] + matrix[1][2];
        int row3 = matrix[2][0] + matrix[2][1] + matrix[2][2];

        int col1 = matrix[0][0] + matrix[1][0] + matrix[2][0];
        int col2 = matrix[0][1] + matrix[1][1] + matrix[2][1];
        int col3 = matrix[0][2] + matrix[1][2] + matrix[2][2];

        int diag1 = matrix[0][0] + matrix[1][1] + matrix[2][2];
        int diag2 = matrix[0][2] + matrix[1][1] + matrix[2][0];

        System.out.println( String.format("%2d %2d %2d \n", row1, row2, row3));
        System.out.println( String.format("%2d %2d %2d \n", col1, col2, col3));
        System.out.println( String.format("%2d %2d  \n", diag1, diag2));

        return (-1);
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( magicSquare(intArray) );  //

        } else {
            intArray = new int[][] { {4, 9, 2} , {3, 5, 7} , {8, 1, 6} };
            if (DEBUG) printData();
            System.out.println( magicSquare(intArray) );  //
        }
    }
}
