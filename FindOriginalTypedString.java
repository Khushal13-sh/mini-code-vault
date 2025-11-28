/**
 * Problem: Find the Original Typed String I
 * Difficulty: Easy
 *
 * Alice may have held a key for too long, causing repeated characters.
 * For each sequence of repeating characters, she may have intended fewer repeats,
 * but at most one mistaken repeat is allowed per group.
 *
 * Return how many possible original strings she could have meant.
 */

public class FindOriginalTypedString {

    public int possibleStringCount(String word) {
        int n = word.length();
        int total = 1; // Original string itself is one possibility

        int count = 1;

        // Count repeating character groups
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                if (count > 1) {
                    total += (count - 1); // Add possible reduced variations
                }
                count = 1;
            }
        }

        // Handle last group
        if (count > 1) {
            total += (count - 1);
        }

        return total;
    }

    public static void main(String[] args) {
        FindOriginalTypedString solution = new FindOriginalTypedString();

        // Test cases
        System.out.println(solution.possibleStringCount("abbcccc")); // Expected: 5
        System.out.println(solution.possibleStringCount("abcd"));    // Expected: 1
        System.out.println(solution.possibleStringCount("aaaa"));    // Expected: 4
    }
}
