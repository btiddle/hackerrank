package Algorithms.C02_Implementation.P12_Drawing_Book;

import java.util.*;

/*

n   totalPages   number of pages in the book
p   targetPage   page to turn to

odd pages on right
even pages on left

pageTurns        minimum number of pages to turn to

if targetPage odd, then substract 1

totalPages   targetPage   fromFront   fromBack
6            1            0           3
             2            1           2
             3            1           2
             4            2           1
             5            2           1
             6            3           0


 */

class InputData {
    static int iTotalPages;
    static int iTargetPage;

    static void getData() {
        Scanner in = new Scanner(System.in);
        iTotalPages = in.nextInt();
        iTargetPage = in.nextInt();
        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "iTotalPages: " + iTotalPages + "\n"
            + "iTargetPage: " + iTargetPage + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static int drawingBook(int totalPages, int targetPage) {
        int pageTurns = 0;


        targetPage = (targetPage % 2 == 0) ? targetPage : targetPage - 1;

        int fromFront = targetPage / 2 ;

        int fromBack = (totalPages - targetPage) / 2;

        if (DEBUG) System.out.println("fromFront: " + fromFront + " fromBack: " + fromBack);

        pageTurns = (fromFront <= fromBack) ? fromFront : fromBack;

        return (pageTurns);
    }

    public static void main(String[] args) {

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( drawingBook(iTotalPages, iTargetPage) );

        } else {
            int result;

            iTotalPages = 6;
            iTargetPage = 1;
            if (DEBUG) printData();
            result = drawingBook(iTotalPages, iTargetPage);
            System.out.println(result);
            if (result != 0) System.out.println("result " + result + " when should be 0");

            iTotalPages = 6;
            iTargetPage = 2;
            if (DEBUG) printData();
            result = drawingBook(iTotalPages, iTargetPage);
            System.out.println(result);
            if (result != 1) System.out.println("result " + result + " when should be 1");

            iTotalPages = 6;
            iTargetPage = 3;
            if (DEBUG) printData();
            result = drawingBook(iTotalPages, iTargetPage);
            System.out.println(result);
            if (result != 1) System.out.println("result " + result + " when should be 1");

            iTotalPages = 6;
            iTargetPage = 4;
            if (DEBUG) printData();
            result = drawingBook(iTotalPages, iTargetPage);
            System.out.println(result);
            if (result != 1) System.out.println("result " + result + " when should be 1");

            iTotalPages = 6;
            iTargetPage = 5;
            if (DEBUG) printData();
            result = drawingBook(iTotalPages, iTargetPage);
            System.out.println(result);
            if (result != 1) System.out.println("result " + result + " when should be 1");

            iTotalPages = 6;
            iTargetPage = 6;
            if (DEBUG) printData();
            result = drawingBook(iTotalPages, iTargetPage);
            System.out.println(result);
            if (result != 0) System.out.println("result " + result + " when should be 0");

            iTotalPages = 5;
            iTargetPage = 4;
            if (DEBUG) printData();
            result = drawingBook(iTotalPages, iTargetPage);
            System.out.println(result);
            if (result != 0) System.out.println("result " + result + " when should be 0");

        }
    }
}
