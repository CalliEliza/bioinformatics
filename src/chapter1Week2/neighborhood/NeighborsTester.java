package chapter1Week2.neighborhood;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by callie on 8/26/16.
 */
public class NeighborsTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = scan.nextLine();
        int d = scan.nextInt();
        scan.close();
        Neighbors n = new Neighbors();
        Set<String> ans = n.getNeighbors(pattern,d);
        System.out.print(ans.size()+"\n");
        /*for (String s : ans) {
            System.out.println(s);
        }*/
    }
}
