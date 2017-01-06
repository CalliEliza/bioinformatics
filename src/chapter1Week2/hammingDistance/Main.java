package chapter1Week2.hammingDistance;

import java.util.Scanner;

/**
 * Created by callie on 8/26/16.
 */
public class Main {
    public  static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String g1 = scan.nextLine();
        String g2 = scan.nextLine();
        scan.close();
        int ans = getHammingDistance(g1,g2);
        System.out.print(ans);
    }

    public static int getHammingDistance(String genome1, String genome2) {
        char[] g1 = genome1.toCharArray();
        char[] g2 = genome2.toCharArray();
        int count = 0;
        for (int i=0;i<g1.length-1;++i) {
            if (g1[i] != g2[i]) {
                ++count;
            }
        }
        return count;
    }
}
