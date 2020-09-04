package de.defdesign.quicktipp.ux;

import de.defdesign.quicktipp.numberGenerators.Blacklist;
import de.defdesign.quicktipp.numberGenerators.TippEuroJackpot;
import de.defdesign.quicktipp.numberGenerators.TippLotto;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * User Interface zur Darstellung des Hauptmenus
 */

public class UserInteraction {
    public void mainUserInterface(){
        do {
            System.out.println("Willkommen bei deinem Westlotto Tipp-Generator!");
            System.out.println("Was möchtes du tun?");
            UxUtilities.separator();
            System.out.println("[black]List anlegen");
            System.out.println("[6aus49] Tippreihe generieren");
            System.out.println("[euro]jackpot Tippreihe generieren");
            System.out.println("[exit] um das Programm zu verlassen");
            UxUtilities.separator();
            Scanner choice = new Scanner(System.in);
            String input = choice.nextLine();
            input = input.toLowerCase().strip();
            switch (input) {
                case "black": this.blackListUserInterface();
                break;
                case "6aus49": this.lottoUserInterface();
                break;
                case "euro": this.euroJackpotUserInterface();
                break;
                case "": this.lottoUserInterface();
                break;
                case "exit": System.exit(0);
                default:
                    System.out.println("Falsche Eingabe. Bitte tippe eine der in eckigen Klammern gesetzten Optionen ein " +
                            "und bestätige mit <enter>");
                    UxUtilities.waitSeconds(3000);
                    UxUtilities.clearScreen();
            }
        } while (true);
    }

    /**
     * User Interface für die Generierung und Änderung der Unglückszahlen aka Blacklist
     */

    public void blackListUserInterface(){
        while (true) {
            System.out.println("Deine aktuelle Blacklist:");
            if (!(Blacklist.getBlacklist().blacklistList.size() == 0)) {
                Blacklist.getBlacklist().blacklistList.forEach(x -> System.out.print(x + " "));
            } else {
                System.out.println("Deine Blacklist ist derzeit leer");
            }
            System.out.println();
            System.out.println("Gib die Zahl zwischen 1 und 50 ein, die du entfernen oder hinzufügen möchtest, " +
                    "'99' um die Blacklist zu leeren oder '0', um die Änderungen an der Blacklist abzuschließen:");
            try {
                Scanner choice = new Scanner(System.in);
                int input = choice.nextInt();
                if (input == 0) {
                    System.out.println("Verlasse Blacklistditor - einen Moment Geduld bitte.");
                    UxUtilities.waitSeconds(3000);
                    UxUtilities.clearScreen();
                    break;
                    }
                if (input == 99) {
                    System.out.println("Lösche die Blacklist - einen Moment Geduld bitte.");
                    Blacklist.getBlacklist().blacklistList.clear();
                    UxUtilities.clearScreen();
                    break;
                }
                System.out.println(Blacklist.getBlacklist().handleNumber(input));
                UxUtilities.waitSeconds(3000);
                UxUtilities.clearScreen();
                } catch (IllegalArgumentException iae) {
                    System.out.println("Falsche Eingabe! Bitte gebe eine Zahl zwischen 1 und 50 für einen Eintrag " +
                            "in der Blacklist ein oder eine '0', um die Blacklisterstellung zu verlassen.");
                    UxUtilities.waitSeconds(3000);
                    UxUtilities.clearScreen();
                }
        }
        Blacklist.getBlacklist().saveBlacklistToDisk();
    }

    /**
     * User Interface für die Generierung der Euro-Jackpot-Zahlen
     */

    public void euroJackpotUserInterface() {
        while (true) {
            TippEuroJackpot euroJackpot = new TippEuroJackpot();
            Set<Integer> eurotipp5of50 = new TreeSet<>(euroJackpot.generateTipp(euroJackpot, euroJackpot.getMAX_VALUE_5_OF_50(), euroJackpot.getMAX_SIZE_5_OF_50()));
            Set<Integer> eurotipp2of10 = new TreeSet<>(euroJackpot.generateTipp(euroJackpot, euroJackpot.getMAX_VALUE_2_OF_10(), euroJackpot.getMAX_SIZE_2_OF_10()));
            System.out.println("Deine generierte Tippreihe für '5 aus 50':");
            eurotipp5of50.forEach(x -> System.out.print(x + " "));
            System.out.println("Deine generierte Tippreihe für '2 aus 10':");
            eurotipp2of10.forEach(x -> System.out.print(x + " "));
            UxUtilities.separator();
            System.out.println("Eine weitere Tippreihe generieren? (j/n)");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if (choice.toLowerCase().equals("n")) {
                break;
            } else {
                sc.close();
            }
        }
        UxUtilities.waitSeconds(3000);
        UxUtilities.clearScreen();
    }

    /**
     * User Interface für die Generierung der 6 aus 49 -Zahlen
     */

    public void lottoUserInterface() {
        TippLotto lotto = new TippLotto();
        while (true) {
            Set<Integer> lottoTipp = new TreeSet<>(lotto.generateTipp(lotto, lotto.getMAX_VALUE(), lotto.getMAX_SIZE()));
            System.out.println("Deine generierte Tippreihe für '6 aus 49':");
            lottoTipp.forEach(x -> System.out.print(x + " "));
            System.out.println("Eine weitere Tippreihe generieren? (j/n)");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if (choice.toLowerCase().equals("n")) {
                break;
            } else {
                sc.close();
            }
        }
        UxUtilities.waitSeconds(3000);
        UxUtilities.clearScreen();
    }

}
