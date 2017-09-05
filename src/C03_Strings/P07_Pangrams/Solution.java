package C03_Strings.P07_Pangrams;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.testng.Assert;

class InputData {
    static String iString;     // input string

    static void getData() {
        Scanner in = new Scanner(System.in);
        iString = in.nextLine();

        in.close();
    }

    static void printData() {
        String output = (
            "\n"
            + "iString:  " + iString + "\n"
        );
        System.out.print(output);
    }
}

public class Solution extends InputData {
    static boolean DEBUG = true;
    static boolean TEST = true;

    static String pangram_1st(String sentence) {
        // Use regular expression to solve problem.

        String answer = "";

        // A regex that works with String.matches(). This uses one look ahead
        // for each letter, each of which asserts that the letter is present.
        // The (?i) switch turns on case insensitivity.

        Pattern p = Pattern.compile("(?i)(?=.*a)(?=.*b)(?=.*c)(?=.*d)(?=.*e)"
                + "(?=.*f)(?=.*g)(?=.*h)(?=.*i)(?=.*j)(?=.*k)(?=.*l)(?=.*m)"
                + "(?=.*n)(?=.*o)(?=.*p)(?=.*q)(?=.*r)(?=.*s)(?=.*t)(?=.*u)"
                + "(?=.*v)(?=.*w)(?=.*x)(?=.*y)(?=.*z).*");
        Matcher m = p.matcher(sentence);

        if (m.matches())
            answer = "pangram";
        else
            answer = "not pangram";

        return (answer);
    }

    static String pangram_2nd(String sentence) {
        // Traverse pattern, traverse sentence, and compare both to each other.

        String pattern = "abcdefghijklmnopqrstuvwxyz";
        String answer = "pangram";
        sentence = sentence.toLowerCase();

        pattern:
        for (int pIndex = 0; pIndex < pattern.length(); pIndex++) {
            sentence:
            for (int sIndex = 0; sIndex < sentence.length(); sIndex++) {
                if (pattern.charAt(pIndex) == sentence.charAt(sIndex)) {
                    break sentence;
                } else if (sIndex == sentence.length() - 1) {
                    answer = "not pangram";
                    break pattern;
                }
            }
        }
        return (answer);
    }

    static String pangram_3rd(String sentence) {
        // Java 8 one liner.

//        String result;
//        result = sentence.replaceAll("[^a-zA-z]", "");
//        result = result.toLowerCase();
//        IntStream is = result.chars();
//        Stream s = is.boxed();
//        Object o  = s.collect(Collectors.toSet());
//        String str = ((Collection) o).size() == 26 ? "pangram" : "not pangram";

        return (sentence
                .replaceAll("[^a-zA-z]", "")
                .toLowerCase().chars().boxed()
                .collect(Collectors.toSet())
                .size() == 26 ? "pangram" : "not pangram"
        );
    }

    static String pangram_4th(String sentence) {
        // Using BitSet, in Java
        // Simple Solution in Java O(N)

        BitSet bs = new BitSet(25);

        sentence = sentence.toLowerCase();
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetter(sentence.charAt(i))) {
                bs.set(sentence.charAt(i) - 97);
            }
        }

        if (bs.cardinality() == 26) {
            return ("pangram");
        } else {
            return ("not pangram");
        }
    }

    static String pangram(String sentence) {
        BitSet b = new BitSet();
        sentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for(char c : sentence.toCharArray()){
            if(c >='a' && c <= 'z'){
                b.set(c-'a');
            }
        }

        return (b.cardinality() == 26 ? "pangram" : "not pangram");
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.println(pangram(iString));

        } else {

            iString = "The quick brown fox jumps over the lazy dog.";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "pangram");

            iString = "a b c d e f g h  i j k l m n o p q r s t u v w x y z";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "pangram");

            iString = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "pangram");

            iString = " bcdefghijklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "a cdefghijklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "ab defghijklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abc efghijklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcd fghijklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcde ghijklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdef hijklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefg ijklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefgh jklmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghi klmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghij lmnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijk mnopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijkl nopqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklm opqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmn pqrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmno qrstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnop rstuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopq stuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopqr tuvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopqrs uvwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopqrst vwxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopqrstu wxyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopqrstuv xyz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopqrstuvw yz";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopqrstuvwx z";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");

            iString = "abcdefghijklmnopqrstuvwxy ";
            if (DEBUG) printData();
            actual = pangram(iString);
            System.out.println(actual);
            Assert.assertEquals(actual, "not pangram");
        }
    }
}
