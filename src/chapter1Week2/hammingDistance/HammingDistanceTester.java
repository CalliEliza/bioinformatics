package chapter1Week2.hammingDistance;

/**
 * Created by callie on 8/26/16.
 */
public class HammingDistanceTester {
    public static void main(String[] args) {
        String g1 ="CAGAAAGGAAGGTCCCCATACACCGACGCACCAGTTTA";
        String g2= "CACGCCGTATGCATAAACGAGCCGCACGAACCAGAGAG";
        HammingDistance hd = new HammingDistance(g1,g2);
        System.out.print(hd.getHammingDistance());
    }
}
