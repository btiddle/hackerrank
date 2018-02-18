package Algorithms.C02_Implementation.P14_Electronics_Shop;

import java.util.*;

class InputData {
    static int amountOfMoney;   // the amount of money Monica has
    static int keyboardCount;   // the number of keyboard brands
    static int usbCount;        // the number of USB drive brands
    static int[] keyboards;     // list of keyboards by price
    static int[] usbs;          // list of usb by price

    static void getData() {
        Scanner in = new Scanner(System.in);
        amountOfMoney = in.nextInt();
        keyboardCount = in.nextInt();
        usbCount = in.nextInt();
        keyboards = new int[keyboardCount];
        for (int i = 0; i < keyboardCount; i++) {
            keyboards[i] = in.nextInt();
        }
        usbs = new int[usbCount];
        for (int i = 0; i < usbCount; i++) {
            usbs[i] = in.nextInt();
        }
        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "amountOfMoney: " + amountOfMoney + "\n"
            + "keyboardCount: " + keyboardCount + "\n"
            + "usbCount:      " + usbCount + "\n"
            + "keyboards:     " + Arrays.toString(keyboards) + "\n"
            + "usbs:          " + Arrays.toString(usbs) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static int electronicsShop(int maxToSpend, int[] keyboards, int[] usbs) {
        int maxAmount = -1;

        for (int keyboard : keyboards) {
            for (int usb : usbs) {
                int amount = (keyboard + usb);
                if ( (amount > maxAmount) && (amount <= maxToSpend) ) {
                    maxAmount = amount;
                }
            }
        }
        return (maxAmount);
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( electronicsShop(amountOfMoney, keyboards, usbs) );  //

        } else {
            // 10 2 3 3 1 5 2 8
            amountOfMoney = 10;
            keyboardCount = 2;
            usbCount = 3;
            keyboards = new int[] {3, 1};
            usbs = new int[] {5, 2, 8};
            if (DEBUG) printData();
            System.out.println( electronicsShop(amountOfMoney, keyboards, usbs) );  //

            // 5 1 1 4 5
            amountOfMoney = 5;
            keyboardCount = 1;
            usbCount = 1;
            keyboards = new int[] {4};
            usbs = new int[] {5};
            if (DEBUG) printData();
            System.out.println( electronicsShop(amountOfMoney, keyboards, usbs) );  //

        }
    }
}
