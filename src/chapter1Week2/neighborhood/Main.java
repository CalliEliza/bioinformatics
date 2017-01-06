package chapter1Week2.neighborhood;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by callie on 8/27/16.
 * main for neighbors
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int d = scan.nextInt();
        scan.close();
        Set<String> ans = getNeighbors(text,d);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    public static Set<String> getNeighbors(String pattern, int d) {
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

    public static String getSuffix(String pattern) {
        String remove = pattern.substring(1);
        return remove;
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

    public static String getFirstSymbol(String input) {
        return input.substring(0,1);
    }
}
