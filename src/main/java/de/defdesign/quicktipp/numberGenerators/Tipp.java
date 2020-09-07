package de.defdesign.quicktipp.numberGenerators;

import java.util.*;

/**
 * Parent class for various lotto-subclasses
 */

abstract class Tipp implements tippable{

    /**
     * generates numbers for various lotto-games
     * @param tipp (lotto-object)
     * @param max value for generated numbers
     * @param numbercount number of numbers to be generated
     * @return complete set of numbers
     */

    public Set<Integer> generateTipp(Tipp tipp, int max, int numbercount) {
        TreeSet<Integer> tippSet = new TreeSet<>();
        int additionalnumber;
        do {
            additionalnumber = (int)((Math.random()*max)+1);
            if (!Blacklist.getBlacklist().getBlacklistList().contains(additionalnumber)) {
                tippSet.add(additionalnumber);
            }
        } while (tippSet.size() < numbercount);
        return tippSet;
    }
}
