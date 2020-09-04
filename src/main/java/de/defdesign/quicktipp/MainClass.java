package de.defdesign.quicktipp;

import de.defdesign.quicktipp.numberGenerators.Blacklist;
import de.defdesign.quicktipp.ux.UserInteraction;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Blacklist.getBlacklist().retrieveBlacklistFromDisk();
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.mainUserInterface();
    }
}
