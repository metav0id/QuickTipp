package de.defdesign.quicktipp.numbers;

import java.util.*;

public class Tipp implements tippable{

    final int MAX_NUMBER = 40;
    final int NUMBERCOUNT = 6;

    public boolean dupeCheck(List<Integer> tipp) {
        Set<Integer> tippSet = new HashSet<>(tipp);
        return tippSet.size() == tipp.size();
    }

    public boolean rangeCheck(List<Integer> tippList) {
        Collections.sort(tippList);
        return (tippList.get(0) >1 ) && (tippList.get(tippList.size()-1) <= MAX_NUMBER);
    }

    public boolean blacklistCheck(List<Integer> tippList) {
        Set<Integer> tippSet = new HashSet<>(Blacklist.getBlacklist().blacklistList);
        tippSet.addAll(tippList);
        return tippSet.size() == (tippList.size() + Blacklist.getBlacklist().blacklistList.size());
    }

    public List<Integer> generateTipp(Tipp tipp) {
        List<Integer> tippList = new ArrayList<>();
        int additionalnumber;
        do {
            additionalnumber = (int)((Math.random()*tipp.MAX_NUMBER)+1);
            tippList.add(additionalnumber);
            if (!tipp.dupeCheck(tippList)||!tipp.blacklistCheck(tippList)) {
                tippList.remove(tippList.size()-1);
            }
        } while (tippList.size() < tipp.NUMBERCOUNT);
        return tippList;
    }
}
