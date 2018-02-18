package Algorithms.C03_Strings.P11_Gemstones;

import java.util.*;
import org.testng.Assert;

class InputData {
    static int iSize;          // input size
    static String[] iStrings;  // input string array

    static void getData() {
        Scanner in = new Scanner(System.in);
        iSize = in.nextInt();
        iStrings = new String[iSize];
        for (int index = 0; index < iSize; index++) {
            iStrings[index] = in.next();
        }

        in.close();
    }

    static void printData() {
        String output = (
             "\n"
             + "iSize:    " + iSize + "\n"
             + "iStrings: " + Arrays.toString(iStrings) + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    private static int solve(int size, String[] rocks) {
        HashMap<Character, Integer> allElements = new HashMap<>();
        int count = 0;

        for (String rock : rocks) {

            Set<Character> elements = new HashSet<>();

            for (int i = 0; i < rock.length(); i++) {
                elements.add(rock.charAt(i));
            }
            for (Character element : elements) {
                Integer frequency = allElements.get(element);
                if (frequency == null) {
                    allElements.put(element, 1);
                } else {
                    allElements.put(element, frequency + 1);
                }
            }
        }
        for (Integer frequency : allElements.values()) {
            if (frequency == rocks.length)
                count = count + 1;
        }
        return (count);
    }

    private static final int NUM_ELEMENTS = 26;

    private static int solve_2nd(int size, String[] rocks) {

        /* Initialize BitSet */
        BitSet bitset = new BitSet(NUM_ELEMENTS);
        bitset.set(0, NUM_ELEMENTS);

        /* Create a BitSet for each rock. "AND" it with our original BitSet */
        for (String rock : rocks) {
            BitSet currBitSet = new BitSet(NUM_ELEMENTS);
            for (int i = 0; i < rock.length(); i++) {
                currBitSet.set(rock.charAt(i) - 'a');
            }
            bitset.and(currBitSet);
        }
        return (bitset.cardinality());
    }

    public static void main(String[] args) {

        int actual = 0;

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println( solve(iSize, iStrings) );

        } else {

            iStrings = new String[] { "abcdde", "baccd", "eeabg" };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, 2);
        }
    }
}
