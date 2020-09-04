package de.defdesign.quicktipp.numberGenerators;

import java.util.Set;
import java.util.TreeSet;

public interface tippable {
    // boolean rangeCheck(TreeSet<Integer> tippSet, int max);
    boolean blacklistCheck(TreeSet<Integer> tippSet);
    Set<Integer> generateTipp(Tipp tipp, int max, int numbercount);
}
