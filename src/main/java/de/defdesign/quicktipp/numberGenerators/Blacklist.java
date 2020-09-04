package de.defdesign.quicktipp.numberGenerators;

import java.util.*;

public class Blacklist extends Tipp {

    private static Blacklist blacklist;
    private final int MAX_SIZE = 6;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 50;

    public Set<Integer> blacklistList = new TreeSet<Integer>();

    public static Blacklist getBlacklist(){
        if (Blacklist.blacklist == null) {
            Blacklist.blacklist = new Blacklist ();
        }
        return Blacklist.blacklist;
    }

    public String handleNumber(int blacklistNumber) {
        if (!this.dupeCheck(blacklistList)) {
            blacklistList.remove((Integer)blacklistNumber);
            return "Zahl wurde von deiner Blacklist entfernt.";
        }
        if ((blacklistNumber > this.MAX_VALUE) || (blacklistNumber < this.MIN_VALUE)) {
            return "Zahl kann nicht geblacklistet werden, da außerhalb des wäählbaren Ranges.";
        }
        if (blacklistList.size() >= MAX_SIZE) {
            return "Zahl kann nicht hinzugefügt werden, das die maximale Größe (6) der Blacklist erreicht ist.";
        }
        blacklistList.add(blacklistNumber);
        return "Zahl erfolgreich deiner Blacklist hinzugefügt.";
    }
}
