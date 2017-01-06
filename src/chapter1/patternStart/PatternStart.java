package chapter1.patternStart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by callie on 8/12/16.
 */
public class PatternStart {
    private String pattern;
    private String genome;

    public PatternStart(String pattern, String genome) {
        this.pattern = pattern;
        this.genome = genome;
    }

    public List<Integer> findPatternStart() {
        int length = genome.length();
        int plen = pattern.length();
        int pos = 0;
        List<Integer> startPos = new ArrayList<>();
        for (int i =0;i<length;++i) {
            if (plen <=genome.length()) {
                String t = genome.substring(0, plen);
                if (t.equals(pattern)) {
                    //int pos = genome.indexOf(t);
                    startPos.add(pos+1);
                }
                //++plen;
                ++pos;
                genome = genome.substring(1);
            }
        }
        return startPos;
    }
}
