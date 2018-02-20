package Data_Structures.C01_Arrays.P01_Array_DS;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.Arrays;

import org.testng.annotations.*;
import static org.testng.Assert.*;

import static Data_Structures.C01_Arrays.P01_Array_DS.Solution.*;

public class SolutionTest {

    @Test
    public void test_set_1_given() {
        StringWriter output = new StringWriter();

        String input  =
            "4\n" +
            "1 4 3 2\n";

        int[] numbers = {1, 4, 3, 2};

        assertTrue(Arrays.equals(processUserInput(
            new Scanner(input), new PrintWriter(output, true)), numbers));

        printReverse(numbers, new PrintWriter(output, true));

        assertTrue(output.toString().contains("2 3 4 1"));
    }

    @Test
    public void test_set_2_size_1() {
        StringWriter output = new StringWriter();

        String input  =
            "1\n" +
            "123456789\n";

        int[] numbers = {123456789};

        assertTrue(Arrays.equals(processUserInput(
            new Scanner(input), new PrintWriter(output, true)), numbers));

        printReverse(numbers, new PrintWriter(output, true));

        assertTrue(output.toString().contains("123456789"));
    }

    @Test
    public void test_set_3_size_10_with_negative_numbers() {
        StringWriter output = new StringWriter();

        String input  =
            "10\n" +
            "-1 100 -77 0 4 5 6 6 11 144\n";

        int[] numbers = {-1, 100, -77, 0, 4, 5, 6, 6, 11, 144};

        assertTrue(Arrays.equals(processUserInput(
            new Scanner(input), new PrintWriter(output, true)), numbers));

        printReverse(numbers, new PrintWriter(output, true));

        assertTrue(output.toString().contains("144 11 6 6 5 4 0 -77 100 -1"));
    }
}
