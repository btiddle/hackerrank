package Algorithms.C02_Implementation.P01_Grading_Students;

import java.util.*;

public class Solution {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static int[] getData() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for (int grades_i = 0; grades_i < n; grades_i++) {
            grades[grades_i] = in.nextInt();
        }
        in.close();
        return grades;
    }

    static int[] GradingStudents(int[] data) {

        int[] grades = data;

        for (int index = 0; index < grades.length; index++) {
            if (grades[index] > 37) {
                int dividend = grades[index];
                int divisor = 5;
                int quotient = dividend / divisor;
                int remainder = dividend % divisor;

                if (remainder > 2)
                    grades[index] = (divisor * quotient) + 5;
            }

            System.out.print(grades[index] + (index != grades.length - 1 ? "\n" : ""));
        }
        System.out.println("\n");
        return grades;
    }


    public static void main(String[] args) {
        int[] data = {};

        if (!TEST) {
            data = getData();
            GradingStudents(data);
        } else {
            GradingStudents(new int[]{73, 67, 38, 33});
            //  75  67  40  33

            GradingStudents(new int[]{0, 37, 38, 39, 40, 41, 42, 43, 44, 45});
            //  0  37  40  40  40  41  42  45  45  45
        }
    }
}
