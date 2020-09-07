package de.defdesign.quicktipp.numberGenerators;

import java.util.Set;

/**
 * Interface containing abstract methods for lotto-tipps implementing tippable-interface
 */

public interface tippable {
    Set<Integer> generateTipp(Tipp tipp, int max, int numbercount);
}
