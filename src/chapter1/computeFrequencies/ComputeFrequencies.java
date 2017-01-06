package chapter1.computeFrequencies;

import chapter1.numberToPattern.NumberToPattern;
import chapter1.patternCount.PatternCount;

import java.util.*;

/**
 * Created by callie on 8/13/16.
 */
public class ComputeFrequencies {
    private String genome;
    private int k;
    private Map<String, Integer> count;

    public ComputeFrequencies(String genome, int k) {
        this.genome = genome;
        this.k = k;
    }

    public Map<String,Integer> getFreq() {
        getArray();
        int length = genome.length();
        for (int i = 0; i < length; ++i) {
            if (k <= length) {
                String pattern = genome.substring(i, k);
                PatternCount pc = new PatternCount(genome, pattern);
                int pCount = pc.patternCount();
                for (String s : count.keySet()) {
                    if (s.equals(pattern)) {
                        count.put(pattern,pCount);
                    }
                }
            }
            ++k;
        }
        return count;
    }

    public void getArray() {
        double size = Math.pow(4,k);
        count = new LinkedHashMap<>();
        for (int i =0; i<size;++i) {
            NumberToPattern value = new NumberToPattern(i,k);
            String s = value.getNumToPattern();
            count.put(s,0);
        }
    }
}
