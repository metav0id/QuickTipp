package de.defdesign.quicktipp.numberGenerators;

import java.util.Set;
import java.util.TreeSet;

public class TippEuroJackpot extends Tipp {
    private final int MAX_SIZE_5_OF_50 = 5;
    private final int MAX_SIZE_2_OF_10 = 2;
    private final int MAX_VALUE_5_OF_50 = 50;
    private final int MAX_VALUE_2_OF_10 = 10;

    public int getMAX_SIZE_5_OF_50() {
        return MAX_SIZE_5_OF_50;
    }

    public int getMAX_SIZE_2_OF_10() {
        return MAX_SIZE_2_OF_10;
    }

    public int getMAX_VALUE_5_OF_50() {
        return MAX_VALUE_5_OF_50;
    }

    public int getMAX_VALUE_2_OF_10() {
        return MAX_VALUE_2_OF_10;
    }
}
