package Data_Structures.C01_Arrays.P02_2D_Array_DS;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.Arrays;

import org.testng.annotations.*;
import static org.testng.Assert.*;

import static Data_Structures.C01_Arrays.P02_2D_Array_DS.Solution.*;

public class SolutionTest {

    @Test
    public void test_set_1_given() {
        StringWriter output = new StringWriter();

        String input  =
        "1 1 1 0 0 0\n" +
        "0 1 0 0 0 0\n" +
        "1 1 1 0 0 0\n" +
        "0 0 2 4 4 0\n" +
        "0 0 0 2 0 0\n" +
        "0 0 1 2 4 0\n";

        int[][] array =
            {{ 1, 1, 1, 0, 0, 0 },
             { 0, 1, 0, 0, 0, 0 },
             { 1, 1, 1, 0, 0, 0 },
             { 0, 0, 2, 4, 4, 0 },
             { 0, 0, 0, 2, 0, 0 },
             { 0, 0, 1, 2, 4, 0 }};

        assertTrue(Arrays.deepEquals(processUserInput(
            new Scanner(input), new PrintWriter(output, true)), array));

        printMaxHourglass(array, new PrintWriter(output, true));

        assertTrue(output.toString().contains("19"));
    }

    @Test
    public void test_set_2_lowest_possible_value() {
        StringWriter output = new StringWriter();

        String input  =
            " -9  -9  -9  -9  -9  -9\n" +
            " -9  -9  -9  -9  -9  -9\n" +
            " -9  -9  -9  -9  -9  -9\n" +
            " -9  -9  -9  -9  -9  -9\n" +
            " -9  -9  -9  -9  -9  -9\n" +
            " -9  -9  -9  -9  -9  -9\n";

        int[][] array =
            {{ -9, -9, -9, -9, -9, -9 },
             { -9, -9, -9, -9, -9, -9 },
             { -9, -9, -9, -9, -9, -9 },
             { -9, -9, -9, -9, -9, -9 },
             { -9, -9, -9, -9, -9, -9 },
             { -9, -9, -9, -9, -9, -9 }};

        assertTrue(Arrays.deepEquals(processUserInput(
            new Scanner(input), new PrintWriter(output)), array));

        printMaxHourglass(array, new PrintWriter(output));

        assertTrue(output.toString().contains("-63"));
    }

    @Test
    public void test_set_4_unique_value_in_each_location() {
        // Specification says no value lager than 9, but using here to
        // create 16 unique hourglasses.

        StringWriter output = new StringWriter();

        String input  =
            "  1   2   3   4   5   6\n" +
            "  7   8   9  10  11  12\n" +
            " 13  14  15  16  17  18\n" +
            " 19  20  21  22  23  24\n" +
            " 25  26  27  28  29  30\n" +
            " 31  32  33  34  35  36\n";

        int[][] array =
            {{  1,  2,  3,  4,  5,  6 },
             {  7,  8,  9, 10, 11, 12 },
             { 13, 14, 15, 16, 17, 18 },
             { 19, 20, 21, 22, 23, 24 },
             { 25, 26, 27, 28, 29, 30 },
             { 31, 32, 33, 34, 35, 36 }};

        assertTrue(Arrays.deepEquals(processUserInput(
            new Scanner(input), new PrintWriter(output)), array));

        printMaxHourglass(array, new PrintWriter(output));

        assertTrue(output.toString().contains("203"));
    }

}
