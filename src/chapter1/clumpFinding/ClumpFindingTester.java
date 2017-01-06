package chapter1.clumpFinding;

import java.util.Set;

/**
 * Created by callie on 8/13/16.
 */
public class ClumpFindingTester {
    public static void main(String[] args) {
        String genome = "CGGACTCGACAGATGTGAAGAACGACAATGTGAAGACTCGACACGACAGAGTGAAGAGAAGAGGAAACATTGTAA";
        int k = 5;
        int L = 50;
        int t = 4;
        ClumpFinding cf = new ClumpFinding(genome,k,L,t);
        Set<String> test = cf.findInClump();
        for (String s : test) {
            System.out.print(s+" ");
        }
    }
}
