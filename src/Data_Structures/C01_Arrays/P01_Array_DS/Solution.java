package Data_Structures.C01_Arrays.P01_Array_DS;

import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    final static boolean DEBUG = true;

    static int[] processUserInput() {
        return processUserInput(new Scanner(System.in), new PrintWriter(System.out));
    }

    static public int[] processUserInput(Scanner scanner, PrintWriter output) {
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++)
            numbers[i] = scanner.nextInt();

        return numbers;
    }

    static public void printReverse(int[] num, PrintWriter output) {
        for (int i = num.length - 1; i > -1; i--)
            output.print(num[i] + " ");
        output.println();
    }

    public static void main(String[] args) {

        Scanner myInput = new Scanner(System.in);
        PrintWriter myOutput = new PrintWriter(System.out, true);

        int[] userInput = processUserInput(myInput, myOutput);

        printReverse(userInput, myOutput);
    }

}

