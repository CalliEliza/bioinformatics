package chapter1.patternCount;

/**
 * Created by callie on 8/11/16.
 */
public class PatternCount {
    private String text;
    private String pattern;

    public PatternCount(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    public int patternCount() {
        int count = 0;
        int length = text.length();
        int plen = pattern.length();
        for (int i =0;i<length;++i) {
            if (plen <=length) {
                String t = text.substring(i, plen);
                if (t.equals(pattern)) {
                    ++count;
                }
                ++plen;
            }
        }
        return count;
    }
}
