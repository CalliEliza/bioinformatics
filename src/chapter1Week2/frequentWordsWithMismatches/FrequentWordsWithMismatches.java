package chapter1Week2.frequentWordsWithMismatches;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by callie on 8/26/16.
 */
public class FrequentWordsWithMismatches {
    private String text;
    private int k;
    private int d;

    public FrequentWordsWithMismatches(String text, int k, int d) {
        this.text = text;
        this.k = k;
        this.d = d;
    }

    public Set<String> getFreqWordsWithMismatches() {
        Set<String> frequentPattern = new HashSet<>();
        List<Set> neighborhoods = new ArrayList<>();
        List<String> neighborhoodArray = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        for (int i=0;i+k<text.length();++i) {
            Set<String> temp = getNeighbors(text.substring(i,k+i),d);
            neighborhoods.add(temp);
            for (String s : temp) {
                neighborhoodArray.add(s);
            }
        }
        for (int j=0;j<neighborhoods.size();++j) {
            String pattern = neighborhoodArray.get(j);
            index.add(j,getPatternToNumber(pattern));
            count.add(j,1);
        }
        List<Integer> sortedIndex = new ArrayList<Integer>(index);
        Collections.sort(sortedIndex);
        for (int v=0;v<neighborhoods.size();++v) {
            if (v+1<neighborhoods.size()) {
                if (sortedIndex.get(v) == sortedIndex.get(v + 1)) {
                    count.add(v + 1, count.get(v) + 1);
                }
            }
        }
        int maxCount = Collections.max(count);
        for (int g =0;g<neighborhoods.size();++g) {
            if (count.get(g)==maxCount) {
                String pattern = getNumToPattern(sortedIndex.get(g));
                frequentPattern.add(pattern);
            }
        }
        return frequentPattern;
    }

    public Set<String> getNeighbors(String pattern, int d) {
        Set<String> onlyPattern = new HashSet<>();
        onlyPattern.add(pattern);
        Set<String> nucleotides = new HashSet<>();
        nucleotides.add("A"); nucleotides.add("C"); nucleotides.add("G"); nucleotides.add("T");
        if (d==0) {
            return onlyPattern;
        }
        if (pattern.length()==1) {
            return nucleotides;
        }
        Set<String> neighborhood = new HashSet<>();
        Set<String> suffixNeighbors = getNeighbors(getSuffix(pattern),d);
        for (String s : suffixNeighbors) {
            if (getHammingDistance(getSuffix(pattern), s)<d) {
                for (String s1 : nucleotides) {
                    String temp = s1+s;
                    neighborhood.add(temp);
                }
            } else {
                String temp2 = getFirstSymbol(pattern)+s;
                neighborhood.add(temp2);
            }
        }
        return neighborhood;
    }

    public String getSuffix(String pattern) {
        String remove = pattern.substring(1);
        return remove;
    }

    public int getHammingDistance(String genome1, String genome2) {
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

    public String getFirstSymbol(String input) {
        return input.substring(0,1);
    }

    public int getPatternToNumber(String pattern) {
        if (pattern.equals("")) {
            return 0;
        }
        int runningCount = 0;
        char[] patternList = pattern.toCharArray();
        List<String> intList = new ArrayList<>();
        for (int i =0;i<patternList.length;++i) { // gets int value for each place in string
            String tempLast = Character.toString(patternList[i]);
            int tempInt = symbolToNumber(tempLast);
            String intToString = Integer.toString(tempInt);
            intList.add(intToString);
        }
        Collections.reverse(intList);
        //System.out.print("number value: ");
        /*for (String s : intList) {
            System.out.print(s+" ");
        }*/
        //System.out.println();
        for (int j =0;j<intList.size();++j) {  // converts String to int
            int temp = Integer.parseInt(intList.get(j)); // converts String to int
            // BigInteger bi = BigInteger.valueOf(j); // convert position to BigInteger
            BigInteger four = BigInteger.valueOf(4);
            BigInteger biPow = four.pow(j); // value^4
            BigInteger val = BigInteger.valueOf(temp); //convert int to big integer
            BigInteger mult = biPow.multiply(val);  // val * biPow
            int multInt = mult.intValue();
            //long multVal = mult.longValue();
            //System.out.println(multVal);
            //runningCount+= multVal;
            runningCount+=multInt;
        }
        return runningCount;
    }

    public int symbolToNumber(String symbol) {
        String symbol1 = symbol.toLowerCase();
        int result = 0;
        if (symbol1.equals("a")) {
            result = 0;
        } else if (symbol1.equals("c")) {
            result = 1;
        } else if (symbol1.equals("g")) {
            result = 2;
        } else if (symbol1.equals("t")) {
            result = 3;
        }
        return result;
    }

    public String getNumToPattern(int input) {
        if (k == 1) {
            return numberToSymbol(input);
        }
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<k;++i) {
            int rem = input % 4;
            input = input /4;
            String val = numberToSymbol(rem);
            sb.append(val);
        }
        sb.reverse();
        String ans = sb.toString();
        return ans;
    }

    public String numberToSymbol(int num) {
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
}
