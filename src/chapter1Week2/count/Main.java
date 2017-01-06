package chapter1Week2.count;

import chapter1Week2.hammingDistance.HammingDistance;

import java.util.Scanner;

/**
 * Created by callie on 8/26/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = scan.nextLine();
        String genome = scan.nextLine();
        int d = scan.nextInt();
        scan.close();
        getPatternNumber(pattern,genome,d);
    }

    public static void getPatternNumber(String pattern, String text, int d) {
        int patternLen = pattern.length();
        int textLen = text.length();
        int endPos = patternLen;
        int total = 0;
        for (int i=0;i<textLen;++i) {
            if (endPos<=textLen) {
                int checkLen = endPos - i;
                String p1 = text.substring(i, endPos);
                int hammingDist = getHammingDistance(pattern, p1);
                if (hammingDist <= d) {
                    ++total;
                }
                ++endPos;
            }
        }
        System.out.print(total);
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
}
