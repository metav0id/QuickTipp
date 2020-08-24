package de.defdesign.quicktipp.numbers;

import java.util.List;

public interface tippable {
    boolean dupeCheck(List<Integer> tippList);
    boolean rangeCheck(List<Integer> tippList);
    boolean blacklistCheck(List<Integer> tippList);
    List<Integer> generateTipp(Tipp tipp);
}
