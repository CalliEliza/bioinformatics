package chapter1Week2.neighborhood;

/**
 * Created by callie on 8/26/16.
 */
public class Suffix {
    private static String pattern;

    public Suffix(String pattern) {
        this.pattern = pattern;
    }

    public static String getSuffix() {
        String remove = pattern.substring(1);
        return remove;
    }
}
