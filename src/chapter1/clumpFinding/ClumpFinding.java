package chapter1.clumpFinding;

import chapter1.computeFrequencies.ComputeFrequencies;
import chapter1.numberToPattern.NumberToPattern;

import java.util.*;

/**
 * Created by callie on 8/13/16.
 */
public class ClumpFinding {
    private String genome;
    private int k;  //length of pattern
    private int L;  //clump size, to look for pattern repeats
    private int t;  //repeated at least t-times

    public ClumpFinding(String genome, int k, int l, int t) {
        this.genome = genome;
        this.k = k;
        L = l;
        this.t = t;
    }

    public Set<String> findInClump() {
        Set<String> frequentPatterns = new HashSet<>();
        List<Integer> clump = new ArrayList<>();
        long length = (long) Math.pow(4,k);
        for (int i =0;i<length;++i) {
            clump.add(0);
        }
        int genomeSection = genome.length()-L;
        for (int j =0;j<genomeSection;++j) {
            String text = genome.substring(j,L);
            ComputeFrequencies cf = new ComputeFrequencies(text,k);
            Map<String, Integer> freqArr = cf.getFreq();
            int counter = 0;
            for (String s : freqArr.keySet()) {
                if (freqArr.get(s)>=t) {
                    clump.add(counter,1);
                }
                ++counter;
            }
        }
        for (int w = 0;w<length;++w) {
            if (clump.get(w) == 1) {
                NumberToPattern np = new NumberToPattern(w,k);
                String pattern = np.getNumToPattern();
                frequentPatterns.add(pattern);
            }
        }
        return frequentPatterns;
    }
}
