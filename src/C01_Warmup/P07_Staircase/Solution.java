package C01_Warmup.P07_Staircase;

import java.util.*;

public class Solution {
    public static boolean DEBUG = true;
    public static boolean TEST = true;

    // get value
    static int getValue() {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        in.close();
        return input;
    }


    static void Staircase(int size) {
        String step = "#";
        int space_count = size - 1;
        int step_count = 1;

        for (int index = 0; index < size; index++){
            String steps = new String(new char[step_count]).replace("\0", "#");
            String format = "%" + size + "s%n";
            System.out.printf(format, steps);
            space_count -= 1;
            step_count += 1;
        }
    }

    public static void main(String[] args) {
        int size = 0;

        if (!TEST) {
            size = getValue();
            Staircase(size);
        } else {
            Staircase(1);

            Staircase(2);

            Staircase(5);

            Staircase(20);

            Staircase(60);
        }
    }
}