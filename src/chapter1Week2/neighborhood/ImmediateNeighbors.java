package chapter1Week2.neighborhood;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by callie on 8/26/16.
 */
public class ImmediateNeighbors {
    private String pattern;

    public ImmediateNeighbors(String pattern) {
        this.pattern = pattern;
    }

    public Set<String> getImmediateNeighbors() {
        Set<String> neighborhood = new HashSet<>();
        neighborhood.add(pattern);
        Set<String> nucleotides = new HashSet<>();
        nucleotides.add("A"); nucleotides.add("T"); nucleotides.add("C"); nucleotides.add("G");
        for (int i=1;i<pattern.length();++i) {
            String symbol = pattern.substring(i,i+1);
            nucleotides.remove(symbol);
            for (String s : nucleotides) {
                String neighbor = pattern.replace(symbol,s);
                neighborhood.add(neighbor);
            }
        }
        return neighborhood;
    }
}
