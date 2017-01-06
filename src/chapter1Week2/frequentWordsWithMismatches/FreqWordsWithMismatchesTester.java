package chapter1Week2.frequentWordsWithMismatches;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by callie on 8/27/16.
 */
public class FreqWordsWithMismatchesTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int k = scan.nextInt();
        int d = scan.nextInt();
        FrequentWordsWithMismatches fw = new FrequentWordsWithMismatches(text,k,d);
        Set<String> fwSet = fw.getFreqWordsWithMismatches();
        for (String s : fwSet) {
            System.out.print(s+" ");
        }
    }
}
