package Algorithms.C01_Warmup.P01_Solve_Me_First;

import java.util.*;

public class Solution {

    static int solveMeFirst(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        // input: 2 2
        // answer: 4
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}
