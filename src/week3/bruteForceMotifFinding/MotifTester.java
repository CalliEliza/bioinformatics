package week3.bruteForceMotifFinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chewy on 1/25/17.
 */
public class MotifTester {

    public static void main(String[] args) {
        int kTest = 3;
        int dTest = 1;
        List<String> dnaTest = new ArrayList<>(Arrays.asList("ATTTGGC","TGCCTTA","CGGTATC","GAAAATT"));
        MotifFinding motifTest = new MotifFinding(dnaTest,kTest,dTest);
        motifTest.MotifEnumeration();
        //motifTest.getKmersPatter("ATTTGGC", 3);

    }
}
