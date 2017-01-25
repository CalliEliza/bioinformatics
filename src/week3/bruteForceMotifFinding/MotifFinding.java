package week3.bruteForceMotifFinding;

/**
 * Created by chewy on 1/25/17.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private String dna;
    private int k;
    private int d;

    public MotifFinding(String dna, int k, int d) {
        this.dna = dna;
        this.k = k;
        this.d = d;
    }

    public void MofitEnumeration() {
        Set<String> pattern = new HashSet<>();
        int len = dna.length();
        for (int i =0;i<len;++i) {

        }
    }
}
