package chapter1.patternToNumber;

/**
 * Created by callie on 8/19/16.
 */
public class PatternToNumTester {
    public static void main(String[] args) {
        PatternToNumber patternToNumber = new PatternToNumber();
        long result = patternToNumber.getPatternToNumber("GTGCGCAGACGGAGGGC");
        System.out.println(result);
    }
}
