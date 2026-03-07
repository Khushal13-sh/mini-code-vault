/**
 * ------------------------------------------------------------
 * Problem : Greatest English Letter in Upper and Lower Case
 * Class   : GreatestEnglishLetterFinder
 * ------------------------------------------------------------
 */

import java.util.HashSet;
import java.util.Set;

class GreatestEnglishLetterFinder {

    public String greatestLetter(String s) {

        Set<Character> set = new HashSet<>();

        // Store all characters
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // Check from Z to A
        for (char c = 'Z'; c >= 'A'; c--) {

            if (set.contains(c) && set.contains(Character.toLowerCase(c))) {
                return String.valueOf(c);
            }
        }

        return "";
    }
}