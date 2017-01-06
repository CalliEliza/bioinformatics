package chapter1Week2;

import chapter1Week2.skew.Skew;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by callie on 8/25/16.
 */
public class SkewTester {
    public static void main(String[] args) throws IOException {
        //String g = new Scanner(new File("data/dataset_7_6.txt")).next();
        String g = "CATTCCAGTACTTCATGATGGCGTGAAGA";

        List<String> genome = new ArrayList<>(Arrays.asList(g.split("")));
        Skew testSkew = new Skew(genome);
        //List<Integer> expectOutcome = new ArrayList<>(Arrays.asList(0,-1,-1,-1,0,1,2,1,1,1,0,1,2,1,0,0,0,0,-1,0,-1,-2));
        List<Integer> actualOutcome = testSkew.getSkewList();
        List<Integer> findOri = testSkew.locateOri();
        /*if (expectOutcome.equals(actualOutcome)) {
            System.out.println("Outcome matches expected outcome");
        } else {
            System.out.println("FAIL");
        }*/
        for (Integer i : actualOutcome) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i =0;i<findOri.size();++i) {
            System.out.print(findOri.get(i)+" ");
        }
    }
}
