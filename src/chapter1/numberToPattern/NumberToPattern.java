package chapter1.numberToPattern;

/**
 * Created by callie on 8/19/16.
 */
public class NumberToPattern {
    private int text;
    private int k;

    public NumberToPattern(int text, int k) {
        this.text = text;
        this.k = k;
    }

    public String getNumToPattern() {
        if (k == 1) {
            return numberToSymbol(text);
        }
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<k;++i) {
            int rem = text % 4;
            text = text /4;
            String val = numberToSymbol(rem);
            sb.append(val);
        }
        sb.reverse();
        String ans = sb.toString();
        return ans;
    }

    public String numberToSymbol(int num) {
        if (num == 0) {
            return "A";
        } else if (num == 1) {
            return "C";
        } else if (num == 2) {
            return "G";
        } else if (num == 3) {
            return "T";
        } else {
            return "Not found";
        }
    }
}
