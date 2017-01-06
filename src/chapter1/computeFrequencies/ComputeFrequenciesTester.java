package chapter1.computeFrequencies;

import java.util.Map;

/**
 * Created by callie on 8/13/16.
 */
public class ComputeFrequenciesTester {
    public static void main(String[] args) {
        String genome = "ACGCGGCTCTGAAA";
        int k = 2;
        ComputeFrequencies cf = new ComputeFrequencies(genome,k);
        String expAns = "2 1 0 0 0 0 2 2 1 2 1 0 0 1 1 0";
        Map<String,Integer> ans = cf.getFreq();
        System.out.println("Expected: "+expAns);
        System.out.print("Result:   ");
        for (Integer i : ans.values()) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (String s : ans.keySet()) {
            System.out.print(s+" ");
        }
    }
}
