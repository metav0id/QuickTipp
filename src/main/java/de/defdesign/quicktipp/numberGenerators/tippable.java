package de.defdesign.quicktipp.numberGenerators;

import java.util.Set;
import java.util.TreeSet;

/**
 * Interface containing abstract methods for lotto-tipps implementing tippable-interface
 */

public interface tippable {
    boolean blacklistCheck(TreeSet<Integer> tippSet);
    Set<Integer> generateTipp(Tipp tipp, int max, int numbercount);
}
