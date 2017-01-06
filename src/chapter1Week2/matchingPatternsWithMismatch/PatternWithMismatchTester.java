package chapter1Week2.matchingPatternsWithMismatch;

import java.util.Scanner;

/**
 * Created by callie on 8/26/16.
 */
public class PatternWithMismatchTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = scan.nextLine();
        String text = scan.nextLine();
        int d = scan.nextInt();
        PatternWithMismatch pm = new PatternWithMismatch(pattern,text,d);
        pm.getPatternIndex();
    }
}
