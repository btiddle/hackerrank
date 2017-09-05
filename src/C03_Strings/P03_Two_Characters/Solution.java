package C03_Strings.P03_Two_Characters;

import org.testng.Assert;
import java.util.*;

class InputData {
    static int size;    // intArray size
    static String string; // char intArray

    static void getData() {
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        string = in.next();
        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "size: " + size + "\n"
            + "string: " + string + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = false;
    static boolean TEST = false;

    static int checkTwoCharacters(String str) {
        int count = 0;
        int index = 2;
        int length = str.length();

        if (length > 1)
            count = index;

        more:
        while (index < length) {
            if (str.charAt(0) == str.charAt(index)) {
                index = index + 1;
                count = index;
                if (index < length) {
                    if (str.charAt(1) == str.charAt(index)) {
                        index = index + 1;
                        count = index;
                    } else {
                        count = 0;
                        break more;
                    }
                } else {
                    break more;
                }
            } else {
                count = 0;
                break more;
            }
        }
        return (count);
    }

    static int solve(int len, String str) {
        int count = 0;
        int result = 0;
        String strNew;

        if (str == null || len < 2)
            return (0);

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(String.valueOf(str.charAt(i)));
        }

        if (set.size() < 2)
            return (0);

        for (String s1 : set) {
            for (String s2 : set) {
                if (s1 == s2) {
                    continue;
                } else {
                    strNew = str.replaceAll("[^" + s1 + s2 + "]", "");
                }
                result = checkTwoCharacters(strNew);
                if (result > count)
                    count = result;
            }
        }
        return (count);
    }

    public static void main(String[] args) {
        int actual;

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println(solve(size, string));  //

        } else {


            size = 0;
            string = null;
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 0);

            size = 1;
            string = "a";
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 0);

            size = 2;
            string = "ab";
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 2);

            size = 4;
            string = "abab";
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 4);

            size = 4;
            string = "abaa";
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 0);

            size = 10;
            string = "beabeefeab";
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 5);

            size = 63;
            string = "baybqwertyabuiopabsdfghatbjklzzabxcvnmabqwertabyuiopabsdfghjkla";
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 18);

            // test case 4 (simple)
            size = 31;
            string = "babaaabbbaaaabbaaabbbaaaabababa";
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 0);

            // test case 4
            size = 375;
            string = "uyetuppelecblwipdsqabzsvyfaezeqhpnalahnpkdbhzjglcuqfjnzpmbwprelbayyzovkhacgrglrdpmvaexkgertilnfooeazvulykxypsxicofnbyivkthovpjzhpohdhuebazlukfhaavfsssuupbyjqdxwwqlicbjirirspqhxomjdzswtsogugmbnslcalcfaxqmionsxdgpkotffycphsewyqvhqcwlufekxwoiudxjixchfqlavjwhaennkmfsdhigyeifnoskjbzgzggsmshdhzagpznkbahixqgrdnmlzogprctjggsujmqzqknvcuvdinesbwpirfasnvfjqceyrkknyvdritcfyowsgfrevzon";
            if (DEBUG) printData();
            actual = solve(size, string);
            System.out.println(actual);
            Assert.assertEquals(actual, 0);
        }
    }
}
