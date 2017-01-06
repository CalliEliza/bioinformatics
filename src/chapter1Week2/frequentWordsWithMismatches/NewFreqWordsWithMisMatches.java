package chapter1Week2.frequentWordsWithMismatches;

import chapter1.numberToPattern.NumberToPattern;
import chapter1Week2.hammingDistance.HammingDistance;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by callie on 8/27/16.
 */
public class NewFreqWordsWithMisMatches {
    private String pattern;
    private int k;
    private int d;
    private Map<String, Integer> count;

    public NewFreqWordsWithMisMatches(String pattern, int k, int d) {
        this.pattern = pattern;
        this.k = k;
        this.d = d;
    }

    public void getMap() {  //creates all 4^k-mers patterns
        double size = Math.pow(4,k);
        count = new LinkedHashMap<>();
        for (int i =0; i<size;++i) {
            NumberToPattern value = new NumberToPattern(i,k);
            String s = value.getNumToPattern();
            count.put(s,0);
        }
    }

    public int getPatternNumber(String text,String pat,int d) {
        int patternLen = pat.length();
        int textLen = text.length();
        int endPos = patternLen;
        int total = 0;
        for (int i=0;i<textLen;++i) {
            if (endPos<=textLen) {
                int checkLen = endPos - i;
                String p1 = text.substring(i, endPos);
                HammingDistance hd = new HammingDistance(pat, p1);
                int hammingDist = hd.getHammingDistance();
                if (hd.getHammingDistance() <= d) {
                    ++total;
                }
                ++endPos;
            }
        }
        return total;
    }

    public List<String> getFeqWordsWithMismatches() {
        getMap();
        List<String> frequentWords = new ArrayList<>();
        for (String s : count.keySet()) { //sets value associated with pattern
            int temp = getPatternNumber(pattern,s,d);
            count.put(s,getPatternNumber(pattern,s,d));
        }
        int maxValue = 0;
        for (Integer i : count.values()) { //finds max value
            if (i>maxValue) {
                maxValue = i;
            }
        }
        for (String s : count.keySet()) { // pulls all patterns with value == maxValue
            if (count.get(s)==maxValue) {
                frequentWords.add(s);
            }
        }
        return frequentWords;
    }
}
