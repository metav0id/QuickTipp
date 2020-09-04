package de.defdesign.quicktipp.numberGenerators;

import java.util.*;

public class TippLotto extends Tipp {
    private final int MAX_SIZE = 6;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 49;
    Set<Integer> tipp = new TreeSet<>();

    public Set<Integer> generateTipp(Tipp tipp, int MAX_VALUE, int MAX_SIZE) {
        TreeSet<Integer> tippSet = new TreeSet<>();
        do {
            tippSet.add((int)((Math.random()*MAX_VALUE)+1));
        } while (tippSet.size() < MAX_SIZE);
        return tippSet;
    }
}
