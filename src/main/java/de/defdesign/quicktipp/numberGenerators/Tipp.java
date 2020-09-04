package de.defdesign.quicktipp.numberGenerators;

import java.util.*;

public class Tipp implements tippable{

    public boolean dupeCheck(Set<Integer> tipp) {
        Set<Integer> tippSet = new TreeSet<>(tipp);
        return tippSet.size() == tipp.size();
    }

    public boolean rangeCheck(TreeSet<Integer> tippSet, int max) {
        return ((tippSet.first() >1 ) && (tippSet.last()) <= max);
    }

    public boolean blacklistCheck(TreeSet<Integer> tippSet) {
        Set<Integer> aggregatedSet = new TreeSet<>(Blacklist.getBlacklist().blacklistList);
        aggregatedSet.addAll(tippSet);
        return aggregatedSet.size() == (tippSet.size() + Blacklist.getBlacklist().blacklistList.size());
    }

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
