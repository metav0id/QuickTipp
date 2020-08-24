package de.defdesign.quicktipp.ux;

import de.defdesign.quicktipp.numbers.Blacklist;

import java.util.Scanner;

public class UserInteraction {
    public void mainUserInterface(){
        System.out.println("Willkommen zu Westlotto");
        System.out.println("Was möchtes du tun");
        System.out.println("[black]List anlegen");
        System.out.println("[6aus49] Tippreihe generieren");
        System.out.println("[eurojackpot] Tippreihe generieren");
        Scanner choice = new Scanner(System.in);
        String input = choice.nextLine();
        input = input.toLowerCase().strip();
        if (input.equals("black")) {
            this.blackListUserInterface();
        }
        if (input.equals("6aus49")||(input.equals("eurojackpot"))) {

        }
        if (input.equals("eurojackpot")) {

        }

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
            System.out.println("Gib die Zahl ein, die du entfernen oder hinzufügen möchtest oder 'x', " +
                    "um die Änderungen an der Blacklist abzuschließen:");
            Scanner choice = new Scanner(System.in);
            int input = choice.next().charAt(0);
            if (input == 'x') {
                break;
            }
            System.out.println(Blacklist.getBlacklist().handleNumber((int)input));
            input = choice.next().charAt(0);
            UxUtilities.clearScreen();
        }
    }
}
