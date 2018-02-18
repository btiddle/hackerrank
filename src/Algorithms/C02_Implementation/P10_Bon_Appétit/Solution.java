package Algorithms.C02_Implementation.P10_Bon_Appetit;

import java.util.*;

class InputData {
    static int iCount;
    static int iSkipped;
    static int[] iPrices;
    static int iAnnaShare;

    static void getData() {
        Scanner in = new Scanner(System.in);
        iCount = in.nextInt();
        iSkipped = in.nextInt();
        iPrices = new int[iCount];
        for (int i = 0; i < iCount; i++) {
            iPrices[i] = in.nextInt();
        }
        iAnnaShare = in.nextInt();
        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "iCount:     " + iCount + "\n"
            + "iSkipped:   " + iSkipped + "\n"
            + "iPrices:    " + Arrays.toString(iPrices) + "\n"
            + "iAnnaShare: " + iAnnaShare + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static void bonAppetit(int count, int skipped, int charged, int[] prices) {
        int total = 0;

        for (int itemCost : prices) {
            total += itemCost;
        }

        int annaShare = ( (total - prices[skipped]) / 2);

        if (charged == annaShare)
            System.out.println("Bon Appetit");
        else
            System.out.println(charged - annaShare);
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            bonAppetit(iCount, iSkipped, iAnnaShare, iPrices);  // 5

        } else {
            // 4 1 3 10 2 9 12
            iCount   = 4;
            iSkipped = 1;
            iPrices = new int[] {3, 10, 2, 9};
            iAnnaShare = 12;
            if (DEBUG) printData();
            bonAppetit(iCount, iSkipped, iAnnaShare, iPrices);  // 5

            // 4 1 3 10 2 9 7
            iCount   = 4;
            iSkipped = 1;
            iPrices = new int[] {3, 10, 2, 9};
            iAnnaShare = 7;
            if (DEBUG) printData();
            bonAppetit(iCount, iSkipped, iAnnaShare, iPrices);  // Bon Appetit

        }
    }
}
