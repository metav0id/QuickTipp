package de.defdesign.quicktipp.numbers;

import java.util.*;

public class Blacklist extends Tipp {

    private static Blacklist blacklist;
    private final int MAX_SIZE = 6;

    public List<Integer> blacklistList = new ArrayList<Integer>();

    public static Blacklist getBlacklist(){
        if (Blacklist.blacklist == null) {
            Blacklist.blacklist = new Blacklist ();
        }
        return Blacklist.blacklist;
    }
    public String handleNumber(int blacklistNumber) {
        if (!this.dupeCheck(blacklistList)) {
            blacklistList.remove((Integer)blacklistNumber);
            return "Zahl wurde von deiner Blacklist entfernt. Weiter mit <Space>";
        }
        if ((blacklistNumber > 50) || (blacklistNumber < 0)) {
            return "Zahl kann nicht geblacklistet werden, da außerhalb des wäählbaren Ranges. Weiter mit <Space>";
        }
        if (blacklistList.size() >= MAX_SIZE) {
            return "Zahl kann nicht hinzugefügt werden, das die maximale Größe (6) der Blacklist erreicht ist. " +
                    "Weiter mit <Space>";
        }
        blacklistList.add(blacklistNumber);
        return "Zahl erfolgreich deiner Blacklist hinzugefügt. Weiter mit <Space>";
    }
}
