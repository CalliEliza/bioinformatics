package chapter1.symbolToNumber;

/**
 * Created by callie on 8/19/16.
 */
public class LastSymbol {
    private String lastSymbol;

    public LastSymbol(String lastSymbol) {
        this.lastSymbol = lastSymbol;
    }

    public String removeLast(String lastSymbol) {
        int length = lastSymbol.length();
        String lastChar = lastSymbol.substring(length-1);
        return lastChar;
    }
}
