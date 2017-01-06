package chapter1.patternToNumber;

import chapter1.symbolToNumber.LastSymbol;
import com.sun.imageio.plugins.common.BogusColorSpace;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by callie on 8/19/16.
 */
public class PatternToNumber {

    public long getPatternToNumber(String pattern) {
        if (pattern.equals("")) {
            return 0;
        }
        long runningCount = 0;
        char[] patternList = pattern.toCharArray();
        List<String> intList = new ArrayList<>();
        for (int i =0;i<patternList.length;++i) { // gets int value for each place in string
            String tempLast = Character.toString(patternList[i]);
            int tempInt = symbolToNumber(tempLast);
            String intToString = Integer.toString(tempInt);
            intList.add(intToString);
        }
        Collections.reverse(intList);
        System.out.print("number value: ");
        /*for (String s : intList) {
            System.out.print(s+" ");
        }*/
        //System.out.println();
        for (int j =0;j<intList.size();++j) {  // converts String to int
            int temp = Integer.parseInt(intList.get(j)); // converts String to int
           // BigInteger bi = BigInteger.valueOf(j); // convert position to BigInteger
            BigInteger four = BigInteger.valueOf(4);
            BigInteger biPow = four.pow(j); // value^4
            BigInteger val = BigInteger.valueOf(temp); //convert int to big integer
            BigInteger mult = biPow.multiply(val);  // val * biPow
            long multVal = mult.longValue();
            //System.out.println(multVal);
            runningCount+= multVal;
        }
        return runningCount;
    }

    public int symbolToNumber(String symbol) {
        String symbol1 = symbol.toLowerCase();
        int result = 0;
        if (symbol1.equals("a")) {
            result = 0;
        } else if (symbol1.equals("c")) {
            result = 1;
        } else if (symbol1.equals("g")) {
            result = 2;
        } else if (symbol1.equals("t")) {
            result = 3;
        }
        return result;
    }
}
