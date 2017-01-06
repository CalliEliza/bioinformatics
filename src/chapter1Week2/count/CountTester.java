package chapter1Week2.count;

import java.util.Scanner;

/**
 * Created by callie on 8/26/16.
 *
 *
 */
public class CountTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = scan.nextLine();
        String genome = scan.nextLine();
        int d = scan.nextInt();
        scan.close();
        Count c = new Count(pattern,genome,d);
        System.out.print(c.getPatternNumber());
    }
}
