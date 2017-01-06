package chapter1.fasterFrequentWords;

import java.util.List;

/**
 * Created by callie on 8/12/16.
 */
public class FasterFrequentWordsTester {
    public static void main(String[] args) {
        String text = "CGGAGGACTCTAGGTAACGCTTATCAGGTCCATAGGACATTCA";
        int k = 3;
        FasterFrequentWords fw = new FasterFrequentWords(text,k);
        List<String> result = fw.getFreqWords();
        for (String s : result) {
            System.out.println("Most frequent amino acid: "+s);
        }
    }
}
