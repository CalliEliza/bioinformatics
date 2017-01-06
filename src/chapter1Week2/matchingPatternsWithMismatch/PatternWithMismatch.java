package chapter1Week2.matchingPatternsWithMismatch;

import chapter1Week2.hammingDistance.HammingDistance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by callie on 8/26/16.
 */
public class PatternWithMismatch {
    private String pattern;
    private String text;
    private int d;

    public PatternWithMismatch(String pattern, String text, int d) {
        this.pattern = pattern;
        this.text = text;
        this.d = d;
    }

    public void getPatternIndex() {
        int patternLen = pattern.length();
        int textLen = text.length();
        int endPos = patternLen;
        List<Integer> patternPos = new ArrayList<>();
        for (int i=0;i<textLen;++i) {
            if (endPos<=textLen) {
                int checkLen = endPos - i;
                String p1 = text.substring(i, endPos);
                HammingDistance hd = new HammingDistance(pattern, p1);
                int hammingDist = hd.getHammingDistance();
                if (hd.getHammingDistance() <= d) {
                    patternPos.add(i);
                }
                ++endPos;
            }
        }
        for (Integer i : patternPos) {
            System.out.print(i+" ");
        }
    }
}
