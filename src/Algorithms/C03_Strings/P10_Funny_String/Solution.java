package Algorithms.C03_Strings.P10_Funny_String;

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

    /*
    Using loop index for start, start + 1, end - 1, and end.

    Funny String
    https://www.hackerrank.com/challenges/funny-string

    Learning:

    • When test result has multiple states, change test cases to display results
      in different order, i.e "Funny,Not Funny" and "Not Funny,Funny". This
      catches when a variable is initialized correctly the 1st time, but is
      incorrect in subsequent iterations (i.e. boolean isFunny = true;).

    • When need to simultaneously look at string's start and start + 1, begin
      loop counter at 1 (instead of 0).

    • Can use loop index to simultaneously move from start of string and
      end of string; for start, start + 1, end - 1, and end.

    */
    static String solve(int size, String[] strs) {

        String answer = "";

        for (String str : strs) {
            boolean isFunny = true;
            int len = str.length();
            for (int i = 1; i < len; i++) {
                if (Math.abs(str.charAt(i) - str.charAt(i - 1)) ==
                    Math.abs(str.charAt(len - i - 1) - str.charAt(len - i))) {
                    // no opp
                } else {
                    isFunny = false;
                    break;
                }
            }
            answer += isFunny ? "Funny\n" : "Not Funny\n";
        }
        return (answer);
    }

    public static void main(String[] args) {

        String actual = "";

        if (!TEST) {
            getData();
            if (DEBUG) printData();
            System.out.print( solve( iSize, iStrings) );

        } else {

            // 01
            iStrings = new String[] {
            "rjdjjhqjhkphjhfxjplmqgrlinztqwtjhvspfixnupufxycippuhunrcbrxqpqzwntnrblhwcdcybdjqtfworqrrjokzelxtelmgxsdbueyxijpcnlpfdixlwhnctkuywhfvyhvvmwstfhustlwwtvjpfvqxinwetdzrjuowqgpvmmpgwnerioimkbkrniwgkvyusnqkuhfhsvoritishseqspjhyioidoewbvhxdneujtnsmxkuponjfvpeffnisrgvmmsozxlisxcgumzlcmtgkklooyxhpecdpvrosexkdzpxnoiqdcvmnjcchzixflztgskxvjjykxxwnhmpkkdxsfybgixksydzroyoxhohgngsurke"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Not Funny\n");

            //02
            iStrings = new String[] {
                    "tuvqxpwrzxqsyumotzrxuzsxqxsvpsxzwqxzuztyrvptmrxtwrsxzstlrwyvouywzxumtlpuyzrtytyrtyvyuxzyqtwqyszwoprxytvzuvqrxzrysuvwrtuyuxyvwotltzumouxrxpwpxrxuomuztltowvyxuyutrwvusyrzxrqvuzvtyxrpowzsyqwtqyzxuyvytrytytrzyupltmuxzwyuovywrltszxsrwtxrmtpvrytzuzxqwzxspvsxqxszuxrztomuqwunltyrzsxwv"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Funny\n");

            //03
            iStrings = new String[] {
                    "wqxyruwpvqszrtzvwrtytwyrsztmouywsuxzuyqstumuwruwyuounuyrxzunumuwxzwrxuntwqvqtmswzvwxzvovqtyuwrwyskruwrzvxtlpsyrwxqvxuxyrwrtzyryrxstmnoqtxztzsxzsvpxskswsxstyvnqyuysxtlszyuzskqvyuyruywpxqxtuovwywqwrwsvqxqtmryzrunpvwotmtlswqxszuwzytztxtlnvoqxyqrxpxztzytvorxszrzrvqvowsksuvprsyrztlruvxtmqsvyzxzvpvystvqtwyuxpsuzxqxzrumquxrvzszxtunruxrwsunqumtyrxqwouvyqwquyuzsxuxqvnqyzyvzrstztmqvzvosuyrworvzuoqrwskquwxuxyzryuzwpsyqxtysyqrtywyzuvpxunpunptzumuyvqtumtunvurwtxpxsyuszuszwoutyxzxsqpxrxswpxrovytxqyzyvyxzvpxtyzxrwswzrmtxvryuqvrysmlkswzyzrowryvsxqvzvztnvsrltzsyrwpxtqxzvqwtqmtswyryuqwtpltqywpwytrowtxzwzusrxuouywyzwtrnuywvsmuowpvusyxzrzvnuzuqyqyrwqnusxwqwyqysrzyrpwomuyuouzyvtyrwpvrkszsnvuomtqyzsnuryrwtxsxrxzxwpvuyryqxzvszvzwrxpwrnmtmuytzvzrowzutytxtltowqnusnuouswtrqpwvqwpwpousxszyvywryxsztqmuqoksxvsltzxsxvzuxszswutswzvpwzupvsyrouzwutrzryrwyszvovpvzxvytrzrqpnvrwyvtxvrxzsyrqxvsxsqvuqwumtrwqxzwpohb"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Funny\n");

            //04
            iStrings = new String[] {
                    "ntzxqxuxqywxruzuzywxpquwrywsxqyvzuywztxysxzwounrxptzrzswqrywpvzwyquytlqswqvyvystwysuvztzvzsvxuzwyqxryvnqyuzxruwoszxtwpqwyrzwxtzxtxprxquzxyszwovpvnowqrxqxsumnuvzxpuntuxqrztwptlqtlpxpqwqwpuotzysxswzuopuounrsyqtyuwswoqrxrxuxrzruywpqswqywyqyzwswsksvwopvpstwyqvqrvpryvwostmruxpvxqrtmnuyvouysvwqwqyumuxtlnvxtmuztlrvnrywzvqysxruwrxzvtswysxvsytzrwspnuqyuowqvnuywomuyvnvzrxrxwztxryvryxqonusmuxuzsrnvuxqouyzupxvsrouonvuxpxtxtqpxpnltzvtszxtqyqwzwqwqpnvzvtxspxrqmtztyxrwzvqvpouztovpvpowokspksovsyqpwtsmtowyutmltrwpwqpvnmuounvyrxwytpwqowswyswvyqxvpovswyrnvtqwupltqyvounvtqvywzswsyswvtzxutzwzwrxtrmuzvrzxuyszxqpvryqyswouqxrzwupvuqwzxtyurzsxtrytrnmutrqvqvsyzxpwtqxqouo"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Not Funny\n");

            //05
            iStrings = new String[] {
                    "sxsuyzsvprtumpsworswosyuvovwzxztmszxrxsvouyrsywowyvotlntzyskmuzrwsuxysxqtlqtztvqytxtxstvqxyrxrxzyrvwstmtlpqvwzxpwrvxyuxrtxtmnopqyuvyunosuworvwywrwztuortuopqwxytxyqyrzwxywzvyuzstlpqvprwzxstvqvpuytwszwskpxzyuvwzvwprtwswptyvwyrvpryuyvzywrsxstlmntvxytyrsuwxumqrsvzuzsxrvqskpqytmntmsvqwsysystztwywpxrvywqtztvxtwoqywpuzvxzywovqrzwounqxtytuouzrwqxrvywoswouxrtwquwzxtuzrwqwzxszswruouwyzyrunvquxqwrtzywztmryvysyrzvqrwrsvnuwwunvsrwrqvzrysyvyrmtzwyztrwqxuqvnuryzywuourwszsxzwqwrzutxzwuqwtrxuowsowyvrxqwrzuoutytxqnuowzrqvowyzxvzupwyqowtxvtztqwyvrxpwywtztsysyswqvsmtnmtyqpksqvrxszuzvsrqmuxwusrytyxvtnmltsxsrwyzvyuyrpvrywvytpwswtrpwvzwvuyzxpkswzswtyupvqvtsxzwrpvqpltszuyvzwyxwzryqyxtyxwqpoutroutzwrwywvrowusonuyvuyqponmtxtrxuyxvrwpxzwvqpltmtswvryzxrxryxqvtsxtxtyqvtztqltqxsyxuswrzumksyztnltovywowysryuovsxrxzsmtzxvyzszyuoksonkswtqyxzxrovuqoje"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Funny\n");

            //06
            iStrings = new String[] {
                    "celtxstyrxuxsxsuxtuowxzvwsvnszyqyqyvzrywrswxrzxpsuspxzrxwsrwyrzvyqyqyzsnvyutxzyqwvzwuzuzwtzsxwrnvom"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Funny\n");

            //07
            iStrings = new String[] {
                    "kqtumotzxtzyvnrtmryrzswopsuwptxtuoskrztlpstzxtltuovnrtmqvwqtxyrvpruyworwyvxtmnqxrsywzuzsxzyqszwpqvxzuztzszytlppltyzsztzuzxvqpwzsqyzxszuzwysrxqnmtxvywrowyurpvryxtqwvqmtrnvoutltxztspltzrksoutxtpwuspowszryrmtrnvsrxtrxsqyxuo"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Funny\n");

            //08
            iStrings = new String[] {
                    "ekqvyuvzumsvxtwqwsuwxpxpxszwpszstxuxpsyuwztwpqrvzxsxyuyzrtwptuzvqyswyunrxtzvztmumptlszrxpswzwxqxptvwpxtyuwovovpvwxryrwrxqyzxpwovxzrstwrvzvyvxpxuvqrywrwotyzvyzwsuwsuyqwoskmryzsztlryuwqyszvnuorzszywqwxytvptwsumpwqxpsytuvzsyrxtyrxzvpstltxzwrsyuosvnowxzwpwxsvqtlsytuosklqsytmnpruwzxzvqywrvzxrumqyqrunpxpwszsyqrywzrwpwpsvxtlqtwsuyskpumpqwxrwxtmpsvwxyuxunqxzuwzryvzvxywswtmuxvqovszwtxwvuxuryutysrxwzrwrztxzvspkswurovovqyvtmltzszvowomtqpxpltqwyuytrzuywuxvsqonuztrmltpvuztmurwtyzszwyxpowtpvztsxuswowvsyusyrwsmtnuyxwrxumtzspxvzwsywrqpvpnmtmuxryqmtzrxvzsmuovonupnvzrltxvzxzvyzwsrwrzupnutyzwowuxuyuqvsrqywunvowyzrysxszsyxwqwpwpxvzuyqxwuqyryxurnksyqxqyuxpxqwsouqwszvtxrzuytsovsqyxtxwrwyuyzyrouxzvpmuxuyzszwpmtyqyqyzxzvpvswuxrzuyxtqvpj"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Funny\n");

            //09
            iStrings = new String[] {
                    "mstwptuvptvptyztwzvzsxqxtuwprzxpuwyvqtxztyrstmtwxzskrwqsxqysyzuxztyskszuytzvzvosxsvyzrvqxuwsvpvzwzyvxqxrvzyryrtxuztwsunptlrytwyqvywpqyuyuywyvzuzrumptzuntvqswpqrsunoqsxsxrxqruyqvyvnvouzrunqryvwxyzxzuovyvqtyqtuwrzxuouwosworyqtmuyzuvovyvworumqxpuvqtvztzwosuwyzuwrworzwszuoumrwrwxqxtxtzvovqyqsuystmruwzszyruzwouvpquvovotxrvqxprztmovwxstmuopwzyuxtxyvxrxqrtzruzuvpsuowyunuytuyqumptvzyrtvnuvxuorskounsuzvqrvwovnpstyvovztytmuwxpquzrsyuyvqmtyvzvpowrnmutrzsxsyunuxsromunvuyzuqvtovpltspvywvowuszyusoltpxtsxtmtxzrxvsyzuzwousrysywzyuyvrqnutzryxsrqxvoumkszuyswryryxtsyxrzwrovunuxzwryztxzxpxszsouyuyryzuzupxrxszvyqnvqvtyzxvtpxuouywtyzumtpxurzyvyryzutpxqnvoltpltrxromuzxwzrwtyvsztywyxwvuryxunksxryqyvsnvronuouzuzxzyrponmtxzusmtysoltqytyuxvtxtpltszxupxvsnuowsqxvzwqvsomtmtswsyrywzyvswqwzvtqxsowvyvqvzswswqvrwpxpvqwuxsrxrzsxztovnusrovonmtouswzuxvtowyqovtswpwryuyvsyxsousoutsovsrx"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Not Funny\n");

            //10
            iStrings = new String[] {
            "inkkkriqtswyyyczfvkydjbkqwrlecmnoxyxpgnkxlkxjlwngjolrowjnptqqifefddviriicrfkdczkmnwdbsmnjhfyqjevlisvyzdzrhmvklfvxcbzvmpfutflflirszmrzqqszcnlothnwhnuueyqwfbdpkuikiylbqdzurkimsvjbkdundnlhpowzkgjtgttvxurqhzcywmzgqvssifcxszyefhxmcshbnyqtzttvgudvqwozbryvqwywfxigsqihqxcrtuoypqthojgpcfmrbkpgkyncrvkhulypfmnvfhcsrkjtoumqhexqcntukdcgncvtpirvqsqkeydrvqkctjtxvorhqunfxizprqkklztobxivntwjcrizfbgwxubuecjxuvhhwzuwyernwpvbgfzkghgdeiyhkkeghkmdlgzjmqyiitinbjxgsdkvlkewvicctnfhugrgxpqflzsljpqdtcxgldcjkfkgromovdttslxdlrpvgfxciwhuyldjpnojdcyyettxfqcpiqkpwhsefcbdmdndrdnwelukhphlflcoblgztxfxyfckippbtewxrsjxhrkoclcfxheqhipfpsrwjgydlvccnkywdikhullruqjbzzfosxmbflfqggrursquczbwn"
            };
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Not Funny\n");

            iStrings = new String[] {"acxz", "bcxz"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Funny\nNot Funny\n");

            iStrings = new String[] {"bcxz", "acxz"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Not Funny\nFunny\n");

            iStrings = new String[] {"ivvkxq", "ivvkx"};
            iSize = iStrings.length;
            if (DEBUG) printData();
            actual = solve(iSize, iStrings);
            System.out.println(actual);
            Assert.assertEquals(actual, "Not Funny\nNot Funny\n");
        }
    }
}
