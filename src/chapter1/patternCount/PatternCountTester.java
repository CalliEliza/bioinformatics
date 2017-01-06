package chapter1.patternCount;

import java.io.IOException;

/**
 * Created by callie on 8/11/16.
 */
public class PatternCountTester {
    public static void main(String[] args) throws IOException {
        String text = "GACCATCAAAACTGATAAACTACTTAAAAATCAGT";
        String pattern = "AAA";

        PatternCount pc = new PatternCount(text,pattern);
        int result = pc.patternCount();
        System.out.println("Pattern: "+pattern+" repeats "+result+" times in "+text);
    }
}
