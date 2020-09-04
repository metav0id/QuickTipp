package de.defdesign.quicktipp.numberGenerators;

import java.util.*;

/**
 * Parent class for various lotto-subclasses
 */

abstract class Tipp implements tippable{

    /**
     * checks if generated number is unique based on set-specifics
     * @param tipp (Set containing Integer values)
     * @return true/false if number is unique/not unique
     */

    public boolean dupeCheck(Set<Integer> tipp) {
        Set<Integer> tippSet = new TreeSet<>(tipp);
        return tippSet.size() == tipp.size();
    }

    /**
     * checks if generated number is blacklistet based on set-specifics
     * @param tippSet (TreeSet containing Integer values)
     * @return true/false if generated numbers are blacklisted
     */

    public boolean blacklistCheck(TreeSet<Integer> tippSet) {
        Set<Integer> aggregatedSet = new TreeSet<>(Blacklist.getBlacklist().blacklistList);
        aggregatedSet.addAll(tippSet);
        return aggregatedSet.size() == (tippSet.size() + Blacklist.getBlacklist().blacklistList.size());
    }

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
            if (!Blacklist.getBlacklist().blacklistList.contains(additionalnumber)) {
                tippSet.add(additionalnumber);
            }
        } while (tippSet.size() < numbercount);
        return tippSet;
    }
}
