package chapter1.fasterFrequentWords;

import chapter1.patternCount.PatternCount;

import java.util.*;

/**
 * Created by callie on 8/12/16.
 */
public class FasterFrequentWords {
    private String text;
    private int k;

    public FasterFrequentWords(String text, int k) {
        this.text = text;
        this.k = k;
    }

    public List<String> getFreqWords() {
        List<String> frequentPatterns = new ArrayList<>();
        return  frequentPatterns;
    }
}
