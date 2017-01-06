package chapter1.frequentWords;

import java.util.List;

/**
 * Created by callie on 8/12/16.
 */
public class FrequentWordsTester {
    public static void main(String[] args) {
        String text = "ACGCGGCTCTGAAA";
        int k = 2;
        FrequentWords fw = new FrequentWords(text,k);
        List<String> result = fw.getFreqWords();
        /*for (String s : result) {
            System.out.println("Most frequent amino acid: "+s);
        }*/
    }
}
