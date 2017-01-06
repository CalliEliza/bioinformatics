package chapter1Week2.frequentWordsWithMismatchesReverseComplement;

import java.util.List;
import java.util.Scanner;

/**
 * Created by callie on 8/27/16.
 */
public class FreqWordsMismatchReverseTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int k = scan.nextInt();
        int d = scan.nextInt();
        FreqWordsWithMismatchReverse freqmReverse = new FreqWordsWithMismatchReverse(input,k,d);
        List<String> answer = freqmReverse.getFeqWordsWithMismatches();
        /*for (String s : answer) {
            System.out.print(s+" ");
        }
        System.out.println();*/
        //FreqWordsWithMismatchReverse test = new FreqWordsWithMismatchReverse(complementString(input),k,d);
        List<String> reverseAnswer = freqmReverse.getReversedFreqWordsMismatch();
        List<String> combined = freqmReverse.getCombinedFreqWordsMismatch();
        for (String s : combined) {
            System.out.print(s+" ");
        }
    }

}
