/**
 * Problem: Check If Digits Are Equal in String After Operations I
 * Difficulty: Easy
 *
 * Perform pairwise sum modulo 10 repeatedly until two digits remain.
 * Return true if the final two digits are equal, else false.
 */
import java.util.*;

public class CheckIfDigitsAreEqualAfterOperations {
    public boolean hasSameDigits(String s) {
        // Convert string to list of digits
        List<Integer> digits = new ArrayList<>();
        for (char c : s.toCharArray()) {
            digits.add(c - '0');
        }

        // Perform the operation until only two digits remain
        while (digits.size() > 2) {
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < digits.size() - 1; i++) {
                int newDigit = (digits.get(i) + digits.get(i + 1)) % 10;
                next.add(newDigit);
            }
            digits = next;
        }

        // Check if the final two digits are equal
        return digits.get(0).equals(digits.get(1));
    }

    // --- test ---
    public static void main(String[] args) {
        CheckIfDigitsAreEqualAfterOperations sol = new CheckIfDigitsAreEqualAfterOperations();
        System.out.println(sol.hasSameDigits("3902"));  // true
        System.out.println(sol.hasSameDigits("34789")); // false
        System.out.println(sol.hasSameDigits("111"));   // true
        System.out.println(sol.hasSameDigits("999"));   // false
    }
}
