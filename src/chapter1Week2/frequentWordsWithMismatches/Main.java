package chapter1Week2.frequentWordsWithMismatches;

import java.util.*;

/**
 * Created by callie on 8/27/16.
 */
public class Main {
    private static Map<String, Integer> count;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = scan.nextLine();
        int k = scan.nextInt();
        int d = scan.nextInt();
        List<String> ans = getFeqWordsWithMismatches(pattern,k,d);
        for (String s : ans) {
            System.out.print(s+" ");
        }
    }

    public  static void getMap(int k) {  //creates all 4^k-mers patterns
        double size = Math.pow(4,k);
        count = new LinkedHashMap<>();
        for (int i =0; i<size;++i) {
            String s = getNumToPattern(i,k);
            count.put(s,0);
        }
    }

    public static int getPatternNumber(String text,String pat,int d) {
        int patternLen = pat.length();
        int textLen = text.length();
        int endPos = patternLen;
        int total = 0;
        for (int i=0;i<textLen;++i) {
            if (endPos<=textLen) {
                int checkLen = endPos - i;
                String p1 = text.substring(i, endPos);
                if (getHammingDistance(pat,p1) <= d) {
                    ++total;
                }
                ++endPos;
            }
        }
        return total;
    }

    public static int getHammingDistance(String genome1, String genome2) {
        char[] g1 = genome1.toCharArray();
        char[] g2 = genome2.toCharArray();
        int count = 0;
        for (int i=0;i<g1.length;++i) {
            if (g1[i] != g2[i]) {
                ++count;
            }
        }
        return count;
    }

    public static String getNumToPattern(int text, int k) {
        if (k == 1) {
            return numberToSymbol(text);
        }
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<k;++i) {
            int rem = text % 4;
            text = text /4;
            String val = numberToSymbol(rem);
            sb.append(val);
        }
        sb.reverse();
        String ans = sb.toString();
        return ans;
    }

    public static String numberToSymbol(int num) {
        if (num == 0) {
            return "A";
        } else if (num == 1) {
            return "C";
        } else if (num == 2) {
            return "G";
        } else if (num == 3) {
            return "T";
        } else {
            return "Not found";
        }
    }

    public static List<String> getFeqWordsWithMismatches(String pattern, int k,int d) {
        getMap(k);
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
