package de.defdesign.quicktipp.numberGenerators;

import java.util.Set;
import java.util.TreeSet;

public class TippEuroJackpot extends Tipp {
    private final int MAX_SIZE_5_OF_50 = 5;
    private final int MAX_SIZE_2_OF_10 = 2;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE_5_OF_50 = 50;
    private final int MAX_VALUE_2_OF_10 = 10;
    Set<Integer> tipp5Of50 = new TreeSet<>();
    Set<Integer> tipp2Of10 = new TreeSet<>();

    public Set<Integer> generateTipp() {
        TreeSet<Integer> tippSet = new TreeSet<>();
        do {
            tippSet.add((int)((Math.random()*this.MAX_VALUE_5_OF_50)+1));
        } while (tippSet.size() < MAX_SIZE_5_OF_50);
        return tippSet;
    }

}
