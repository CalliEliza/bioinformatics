package chapter1Week2.count;

import chapter1Week2.hammingDistance.HammingDistance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by callie on 8/26/16.
 * also approximatePatternCount
 */
public class Count {
    private String pattern;
    private String text;
    private int d;

    public Count(String pattern, String text, int d) {
        this.pattern = pattern;
        this.text = text;
        this.d = d;
    }

    public int getPatternNumber() {
        int patternLen = pattern.length();
        int textLen = text.length();
        int endPos = patternLen;
        int total = 0;
        for (int i=0;i<textLen;++i) {
            if (endPos<=textLen) {
                int checkLen = endPos - i;
                String p1 = text.substring(i, endPos);
                HammingDistance hd = new HammingDistance(pattern, p1);
                int hammingDist = hd.getHammingDistance();
                if (hd.getHammingDistance() <= d) {
                    ++total;
                }
                ++endPos;
            }
        }
        return total;
    }
}
