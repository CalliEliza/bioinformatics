package chapter1Week2.frequentWordsWithMismatchesReverseComplement;

import chapter1.numberToPattern.NumberToPattern;
import chapter1Week2.frequentWordsWithMismatches.NewFreqWordsWithMisMatches;
import chapter1Week2.hammingDistance.HammingDistance;

import javax.print.DocFlavor;
import java.util.*;

/**
 * Created by callie on 8/27/16.
 */
public class FreqWordsWithMismatchReverse {
    private String input;
    private int k;
    private int d;
    private Map<String, Integer> count;
    private Map<String, Integer> reverseCount;
    private Map<String,Integer> combinedMap;

    public FreqWordsWithMismatchReverse(String text, int k, int d) {
        this.input = text;
        this.k = k;
        this.d = d;
    }

    public void getMap() {  //creates all 4^k-mers patterns
        double size = Math.pow(4,k);
        count = new TreeMap<>();
        for (int i =0; i<size;++i) {
            NumberToPattern value = new NumberToPattern(i,k);
            String s = value.getNumToPattern();
            count.put(s,0);
        }
    }

    public int getPatternNumber(String text,String pat) {
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
            int temp = getPatternNumber(input,s);
            count.put(s,getPatternNumber(input,s));
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

    public String reverseString(String text) {
        StringBuilder input = new StringBuilder();
        input.append(text);
        input = input.reverse();
        String txet = input.toString();
        return txet;
    }

    public String complementString(String text) {
        String input1 = reverseString(text);
        char[] input2 = input1.toCharArray();
        for (int i = 0; i < input2.length; ++i) {
            if (input2[i] == 'A') {
                input2[i] = 'T';
            } else if (input2[i] == 'T') {
                input2[i] = 'A';
            } else if (input2[i] == 'C') {
                input2[i] = 'G';
            } else if (input2[i] == 'G') {
                input2[i] = 'C';
            }
        }
        String input3 = new String(input2);
        return input3;
    }

    public void getReverseMap() {
        reverseCount = new TreeMap<>();
        for (String s : count.keySet()) {
            String temp = s;
            String temp1 = complementString(s);
            reverseCount.put(complementString(s),0);
        }
    }

    public List<String> getReversedFreqWordsMismatch() {
        getReverseMap();
        //FreqWordsWithMismatchReverse fw = new FreqWordsWithMismatchReverse(complementString(input),k,d);
        List<String> reverseFrequentWords = new ArrayList<>();//fw.getFeqWordsWithMismatches();
        for (String s : reverseCount.keySet()) { //sets value associated with pattern
            int temp = getPatternNumber(input,s);
            reverseCount.put(s,getPatternNumber(input,s));
        }
        int maxValue = 0;
        for (Integer i : reverseCount.values()) { //finds max value
            if (i>maxValue) {
                maxValue = i;
            }
        }
        for (String s : reverseCount.keySet()) { // pulls all patterns with value == maxValue
            if (reverseCount.get(s)==maxValue) {
                reverseFrequentWords.add(s);
            }
        }
        return reverseFrequentWords;
    }

    public Map<String, Integer> combine(Map<String,Integer> map1, Map<String,Integer> map2) {
        combinedMap = new TreeMap<>();
        for (String s : map1.keySet()) {
            int combinedValues = map1.get(s)+map2.get(s);
            combinedMap.put(s,combinedValues);
        }
        for (String s : combinedMap.keySet()) {
            System.out.println(s+" "+combinedMap.get(s));
        }
        return combinedMap;
    }

    public void getCombinedMap() {
        combine(count,reverseCount);
    }

    public List<String> getCombinedFreqWordsMismatch() {
        getCombinedMap();
        List<String> combinedFrequentWordsList = new ArrayList<>();
        for (String s : combinedMap.keySet()) { //sets value associated with pattern
            int temp = getPatternNumber(input,s);
            combinedMap.put(s,getPatternNumber(input,s));
        }
        int maxValue = 0;
        for (Integer i : combinedMap.values()) { //finds max value
            if (i>maxValue) {
                maxValue = i;
            }
        }
        for (String s : combinedMap.keySet()) { // pulls all patterns with value == maxValue
            if (combinedMap.get(s)==maxValue) {
                combinedFrequentWordsList.add(s);
            }
        }
        return combinedFrequentWordsList;
    }
}
