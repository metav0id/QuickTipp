package de.defdesign.quicktipp.ux;

public class UxUtilities {

    public static void clearScreen() {
        for(int i = 0; i<20; i++) {
            System.out.println();
        }
    }

    public static void waitSeconds(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ie) {
            // can't happen
        }
    }

    public static void separator() {
        System.out.println("----------------------------------------------------");
    }
}
