package week3.bruteForceMotifFinding;

/**
 * Created by chewy on 1/25/17.
 */

import chapter1Week2.hammingDistance.HammingDistance;
import chapter1Week2.neighborhood.ImmediateNeighbors;
import chapter1Week2.neighborhood.Neighbors;

import java.util.*;

/*****
      MotifEnumeration(Dna, k, d)
        Patterns ← an empty set
        for each k-mer Pattern in the first string in Dna
        for each k-mer Pattern’ differing from Pattern by at most d mismatches
        if Pattern' appears in each string from Dna with at most d mismatches
        add Pattern' to Patterns
        remove duplicates from Patterns
        return Patterns
*****/


public class MotifFinding {
    private List<String> dna;
    private int k;
    private int d;

    public MotifFinding(List<String> dna, int k, int d) {
        this.dna = dna;
        this.k = k;
        this.d = d;
    }

    public Set<String> MotifEnumeration() {
        Neighbors patternSet = new Neighbors();
        List<String> result = new ArrayList<>();
        int len = dna.size();
        for (int i =0;i<len;++i) {
            List<String> pattern = getKmersPatter(dna.get(i), k);
            for (int j=0;i<pattern.size();++i) {
                Set<String> patternMismatches = patternSet.getNeighbors(pattern.get(i), d);
                List<String> mismatchPattern = new ArrayList<>(patternMismatches);
                int hd = getHammingDistance(dna.get(i), mismatchPattern.get(i));
                if (hd < d) {
                    result.add(mismatchPattern.get(i));
                }

            }
        }
        Set<String> Patterns = new HashSet<>();
        Patterns.addAll(result);
        System.out.println(Patterns);
        return Patterns;
    }

    public List<String> getKmersPatter(String dna, int k) { //gets a list of all k-mers in patter given
        List<String> dnaPattern = new ArrayList<>();
        for (int i =0;i<dna.length();++i) {
            if (i+3 <= dna.length()) {
                dnaPattern.add(dna.substring(i, i + 3));
            }
        }
        return dnaPattern;
    }

    public int getHammingDistance(String genome1, String genome2) {
        char[] g1 = genome1.toCharArray();
        char[] g2 = genome2.toCharArray();
        int count = 0;
        for (int i=0;i<g1.length;++i) {
            if (g1[i] != g2[i]) {
                ++count;
            }
        }
        return count;
    }

}
