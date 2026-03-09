/**
 * ------------------------------------------------------------
 * Problem : Greatest English Letter in Upper and Lower Case
 * Class   : GreatestEnglishLetterDemo
 * ------------------------------------------------------------
 */

import java.util.HashSet;
import java.util.Set;

public class GreatestEnglishLetterDemo {

    public static String greatestLetter(String s) {

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (char c = 'Z'; c >= 'A'; c--) {
            if (set.contains(c) && set.contains(Character.toLowerCase(c))) {
                return String.valueOf(c);
            }
        }

        return "";
    }

    public static void main(String[] args) {

        // Example 1
        String s1 = "lEeTcOdE";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + greatestLetter(s1));

        // Example 2
        String s2 = "arRAzFif";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + greatestLetter(s2));

    }
}