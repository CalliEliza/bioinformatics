package chapter1Week2.frequentWordsWithMismatches;

import java.util.List;
import java.util.Scanner;

/**
 * Created by callie on 8/27/16.
 */
public class NewFreqWordsWithMismatchesTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int k = scan.nextInt();
        int d = scan.nextInt();
        NewFreqWordsWithMisMatches fw = new NewFreqWordsWithMisMatches(input,k,d);
        List<String> ans = fw.getFeqWordsWithMismatches();
        for (String s : ans) {
            System.out.print(s+" ");
        }
    }
}
