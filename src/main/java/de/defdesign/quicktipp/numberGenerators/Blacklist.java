package de.defdesign.quicktipp.numberGenerators;

import de.defdesign.quicktipp.persistence.FileService;

import java.util.*;

/**
 * List of undesirable numbers for generation of lotto-numbers
 */

public class Blacklist extends Tipp {

    private static Blacklist blacklist;
    private final int MAX_SIZE = 6;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 50;

    private Set<Integer> blacklistList = new TreeSet<>();

    public static Blacklist getBlacklist(){
        if (Blacklist.blacklist == null) {
            Blacklist.blacklist = new Blacklist ();
        }
        return Blacklist.blacklist;
    }

    public Set<Integer> getBlacklistList(){
        return this.blacklistList;
    }

    /**
     * loads blacklist from previous sessions from disk
     */

    public void retrieveBlacklistFromDisk(){
        FileService fs = new FileService();
        fs.fileInitializer("blacklist.usr");
        this.blacklistList = fs.readFromDisk("blacklist.usr");
    }

    /**
     * replaces blacklist on disk with current blacklist
     */

    public void saveBlacklistToDisk(){
        FileService fs = new FileService();
        fs.saveToDisk(this.blacklistList, "blacklist.usr");
    }

    /**
     * handles input for blacklist and automatically adds and removes numbers depending on state of blacklist
     * @param blacklistNumber (number added by user)
     * @return String containing comment for user to feedback on action taken
     */

    public String handleNumber(int blacklistNumber) {
        if (!this.dupeCheck(blacklistList, blacklistNumber)) {
            blacklistList.remove(blacklistNumber);
            return "Zahl wurde von deiner Blacklist entfernt.";
        }
        if ((blacklistNumber > this.MAX_VALUE) || (blacklistNumber < this.MIN_VALUE)) {
            return "Zahl kann nicht geblacklistet werden, da außerhalb des wäählbaren Ranges.";
        }
        if (blacklistList.size() >= MAX_SIZE) {
            return "Zahl kann nicht hinzugefügt werden, da die maximale Größe (6) der Blacklist erreicht ist.";
        }
        blacklistList.add(blacklistNumber);
        return "Zahl erfolgreich deiner Blacklist hinzugefügt.";
    }

    /**
     * blacklist-specific dupe-check to provide user with feedback on user-action
     * @param tipp (set containing blacklist)
     * @param blacklistNumber to be checked against blacklist
     * @return true if number is not a dupe
     */

    public boolean dupeCheck(Set<Integer> tipp, Integer blacklistNumber) {
        Set<Integer> tippSet = new TreeSet<>(tipp);
        tippSet.add(blacklistNumber);
        return tippSet.size() != tipp.size();
    }
}
