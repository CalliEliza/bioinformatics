package chapter1.frequentWords;

import chapter1.patternCount.PatternCount;

import java.util.*;

/**
 * Created by callie on 8/12/16.
 */
public class FrequentWords {
    private String text;
    private int k;

    public FrequentWords(String text, int k) {
        this.text = text;
        this.k = k;
    }

    public List<String> getFreqWords() {
        List<String> frequentPatterns = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        int length = text.length();
        for (int i = 0; i < length; ++i) {
            if (k <= length) {
                String pattern = text.substring(i, k);
                PatternCount pc = new PatternCount(text, pattern);
                int pCount = pc.patternCount();
                if (!count.containsKey(pattern)) { //checks to see if pattern already counted
                    count.put(pattern, pCount);  //if not, just add
                } else {  //if so, add counts together first
                    count.put(pattern,pCount+count.get(pattern));
                }
            }
            ++k;
        }
            int maxCount = 0;
            for (Integer value : count.values()) { //loops looking for max value for i
                if (value > maxCount) {
                    maxCount = value;
                }
            }
            for (String key : count.keySet()) {
                if (count.get(key) == maxCount) {
                    frequentPatterns.add(key);
                }
            }
            for (String s : count.keySet()) {
                System.out.print(s+" ");
            } System.out.println();
            for (Integer i : count.values()) {
                System.out.print(i+" ");
            }
        return frequentPatterns;
    }
}
