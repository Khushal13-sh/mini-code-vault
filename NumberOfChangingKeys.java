/**
 * Problem: Number of Changing Keys
 * Difficulty: Easy
 *
 * You are given a string s typed by a user.
 * A key change occurs when the user types a different key than the previous one.
 * Uppercase and lowercase letters of the same character are considered the same key.
 *
 * Approach:
 * 1. Convert the string to lowercase to ignore case differences.
 * 2. Iterate through the string and count transitions between different characters.
 * 3. Return the total count of key changes.
 */

public class NumberOfChangingKeys {

    public int countKeyChanges(String s) {
        s = s.toLowerCase();  // Ignore case differences

        int changes = 0;
        char prev = s.charAt(0);

        for (char c : s.toCharArray()) {
            if (c != prev) {
                changes++;
                prev = c;
            }
        }

        return changes;
    }

    public static void main(String[] args) {
        NumberOfChangingKeys solution = new NumberOfChangingKeys();

        System.out.println(solution.countKeyChanges("aAbBcC"));     // Output: 2
        System.out.println(solution.countKeyChanges("AaAaAaaA"));   // Output: 0
        System.out.println(solution.countKeyChanges("abcABCabc"));  // Output: 2
    }
}
