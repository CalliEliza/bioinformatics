package chapter1Week2.hammingDistance;

/**
 * Created by callie on 8/26/16.
 */
public class HammingDistance {
    private String genome1;
    private String genome2;

    public HammingDistance(String genome1, String genome2) {
        this.genome1 = genome1;
        this.genome2 = genome2;
    }

    public int getHammingDistance() {
        char[] g1 = genome1.toCharArray();
        char[] g2 = genome2.toCharArray();
        int count = 0;
        for (int i=0;i<g1.length;++i) {
            if (g1[i] != g2[i]) {
                ++count;
            }
        }
        return count;
    }
}
