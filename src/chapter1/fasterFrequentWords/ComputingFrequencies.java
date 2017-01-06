package chapter1.fasterFrequentWords;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by callie on 8/19/16.
 */
public class ComputingFrequencies {
    private String text;
    private int k;

    public ComputingFrequencies(String text, int k) {
        this.text = text;
        this.k = k;
    }

    public List<Integer> computeFreq() {
        List<Integer> frequencyArray = new ArrayList<>();
        long length = (long) Math.pow(4,k);
        for (int i =0;i<length;++i) {
            frequencyArray.add(i,0);
        }
        int length2 = text.length()-k;
        for (int j =0;j<length2;++j) {
            String pattern = text.substring(j,k);
           // int tempNum = PatternToNumber(pattern);
           // frequencyArray.add(tempNum,tempNum+1);
        }
        return frequencyArray;
    }
}
