package Data_Structures.C01_Arrays.P02_2D_Array_DS;

import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    final static boolean DEBUG = false;

    static int[][] processUserInput() {
        return processUserInput(new Scanner(System.in), new PrintWriter(System.out));
    }

    static public int[][] processUserInput(Scanner scanner, PrintWriter output) {

        int[][] array = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }

    static public void printMaxHourglass(int[][] arr, PrintWriter output) {
        int maxHourglass = -9 * 7; // lowest possible value

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                int sumHourglass =
                    arr[i + 0][j + 0] +   arr[i + 0][j + 1] + arr[i + 0][j + 2] +
                                          arr[i + 1][j + 1] +
                    arr[i + 2][j + 0] +   arr[i + 2][j + 1] + arr[i + 2][j + 2] ;

                if (DEBUG) {
                    System.out.println(arr[i + 0][j + 0] + " " + arr[i + 0][j + 1] + " " + arr[i + 0][j + 2]);
                    System.out.println("   "             + " " + arr[i + 1][j + 1] + " ");
                    System.out.println(arr[i + 2][j + 0] + " " + arr[i + 2][j + 1] + " " + arr[i + 2][j + 2]);
                    output.println(sumHourglass + "\n");
                }

                if (maxHourglass < sumHourglass)
                    maxHourglass = sumHourglass;
            }
        }
        output.println(maxHourglass);
    }

    public static void main(String[] args) {

        Scanner myInput = new Scanner(System.in);
        PrintWriter myOutput = new PrintWriter(System.out, true);

        int[][] array = processUserInput(myInput, myOutput);

        printMaxHourglass(array, myOutput);
    }

}
