package Algorithms.C01_Warmup.P05_Diagonal_Difference;

import java.util.*;
import static java.lang.Math.abs;

class InputData {
    int size;
    int[][] matrix;

    public String toString() {
        String str = "";
        str =  "size: " + size + "\n";
        str += "matrix: \n";
        for (int[] row : matrix)
            str += Arrays.toString(row) + " ";
        return (str);
    }

    static InputData getData() {
        InputData d = new InputData();
        Scanner in = new Scanner(System.in);
        d.size = in.nextInt();
        d.matrix = new int[d.size][d.size];
        for (int row = 0; row < d.size; row++) {
            for (int column = 0; column < d.size; column++)
                d.matrix[row][column] = in.nextInt();
        }
        in.close();
        return d;
    }
}

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static int DiagonalDifference(InputData d) {
        int result = 0;
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int row = 0; row < d.size; row++) {
            for (int col = 0; col < d.size; col++) {
                if (col == row) {
                    if (DEBUG) System.out.print(d.matrix[row][col] + " ");
                    primaryDiagonal += d.matrix[row][col];
                }
            }
        }
        if (DEBUG) System.out.println(primaryDiagonal);

        for (int row = 0; row < d.size; row++) {
            for (int col = (d.size - 1); col >= 0; col--) {
                if ((col + row) == (d.size - 1)) {
                    if (DEBUG) System.out.print(d.matrix[row][col] + " ");
                    secondaryDiagonal += d.matrix[row][col];
                }
            }
        }
        if (DEBUG) System.out.println(secondaryDiagonal);
        return abs(primaryDiagonal - secondaryDiagonal);
    }

    public static void main(String[] args) {
        InputData data;

        if (!TEST) {
            data = InputData.getData();
            if (DEBUG) System.out.println(data);
            System.out.println(DiagonalDifference(data));
        } else {
            data = new InputData();

            // 3 11 2 4 4 5 6 10 8 -12
            data.size = 3;
            data.matrix = new int[][]{{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};
            if (DEBUG) System.out.println(data);
            System.out.println(DiagonalDifference(data)); /// 15

            // 5 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
            data.size = 5;
            data.matrix = new int[][]{
                    {1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20},
                    {21, 22, 23, 24, 25}
            };
            if (DEBUG) System.out.println(data);
            System.out.println(DiagonalDifference(data)); // 0

            // 5 -1 2 3 4 5 6 -7 8 9 10 11 12 -13 14 15 16 17 18 -19 20 21 22 23 24 -25
            data.size = 5;
            data.matrix = new int[][]{
                {-1, 2, 3, 4, 5},
                {6, -7, 8, 9, 10},
                {11, 12, -13, 14, 15},
                {16, 17, 18, -19, 20},
                {21, 22, 23, 24, -25}
            };
            if (DEBUG) System.out.println(data);
            System.out.println(DiagonalDifference(data)); // 104

            // 2 -1 2 6 -7
            data.size = 2;
            data.matrix = new int[][]{
                {-1, 2},
                {6, -7}
            };
            if (DEBUG) System.out.println(data);
            System.out.println(DiagonalDifference(data)); // 16
        }
    }
}
