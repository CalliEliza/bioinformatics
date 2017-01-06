package chapter1.reverseComplement;

/**
 * Created by callie on 8/12/16.
 * A - T   **DNA Pairing of bases
 * C - G
 */
public class ReverseComplement {
    private String text;

    public ReverseComplement(String text) {
        this.text = text;
    }

    public String reverseString() {
        StringBuilder input = new StringBuilder();
        input.append(text);
        input = input.reverse();
        String txet = input.toString();
        return txet;
    }

    public String complementString() {
        String input1 = reverseString();
        char[] input2 = input1.toCharArray();
        for (int i =0;i<input2.length;++i) {
            if (input2[i] == 'A') {
                input2[i] = 'T';
            }
            else if (input2[i] == 'T') {
                input2[i] = 'A';
            }
            else if (input2[i] == 'C') {
                input2[i] = 'G';
            }
            else if (input2[i] == 'G') {
                input2[i] = 'C';
            }
        }
        String input3 = new String(input2);
        return input3;
    }
}
