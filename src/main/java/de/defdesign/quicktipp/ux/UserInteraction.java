package de.defdesign.quicktipp.ux;

import de.defdesign.quicktipp.numberGenerators.Blacklist;
import de.defdesign.quicktipp.numberGenerators.Tipp;
import de.defdesign.quicktipp.numberGenerators.TippEuroJackpot;

import java.util.Scanner;

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
    }

    public void euroJackpotUserInterface() {
        Tipp euroJackpot = new TippEuroJackpot();
        euroJackpot.generateTipp();
    }

    public void lottoUserInterface() {
    }

}
