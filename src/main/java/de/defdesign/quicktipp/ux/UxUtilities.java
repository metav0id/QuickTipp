package de.defdesign.quicktipp.ux;

import java.sql.SQLOutput;

public class UxUtilities {

    /**
     * Einfache Utility-Methoden für die Darstellung der User-Interfaces
     */

    public static void clearScreen() {
        for(int i = 0; i<20; i++) {
            System.out.println();
        }
    }

    public static void waitSeconds(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ie) {
            // kann nicht auftreten, da lediglich als Warteschleife genutzt
        }
    }

    public static void separator() {
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println();
    }
}
