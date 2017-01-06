package chapter1Week2.skew;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by callie on 8/25/16.
 */
public class Skew {
    private List<String> input;

    public Skew(List<String> skewList) {
        this.input = skewList;
    }

    public List<Integer> getSkewList() {
        List<Integer> skew = new LinkedList<>();
        skew.add(0);
        for (int i =0;i<input.size();++i) {
           // System.out.print(input.get(i)+" ");
            if (input.get(i).equals("C") && i==0) {
                skew.add(-1);
            } else if (input.get(i).equals("C") && i!=0) {
                skew.add(skew.get(i)-1);
            }
            if (input.get(i).equals("A") || input.get(i).equals("T")) {
                    skew.add(skew.get(i));
            } else if (input.get(i).equals("G")) {
                skew.add(skew.get(i)+1);
            }
            //System.out.println(skew.get(i+1));
        }

        return skew;
    }

    public List<Integer> locateOri() {
        List<Integer> genomeList = getSkewList();
        List<Integer> minValue = new ArrayList<>();
        int min = 0;
        for (Integer i : genomeList) {
            if (i > min) {
                min = i;
            }
        }
        for (int i =0;i<genomeList.size();++i) {
            if (genomeList.get(i)==min) {
                minValue.add(i);
            }
        }
        return minValue;
    }
}
