/**
 * Problem: Find Valid Pair of Adjacent Digits in String
 * Difficulty: Easy
 *
 * A valid pair is formed by two adjacent digits such that:
 * 1) Both digits are different.
 * 2) The frequency of each digit in the entire string equals its numeric value.
 *
 * Return the first valid pair encountered from left to right.
 */

public class FindValidAdjacentPair {

    public String findValidPair(String s) {

        // Count frequency of each digit
        int[] freq = new int[10];
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }

        // Check adjacent pairs
        for (int i = 0; i < s.length() - 1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);

            if (first != second && isValid(first, freq) && isValid(second, freq)) {
                return "" + first + second;
            }
        }

        return "";
    }

    // Helper method to validate frequency rule
    private boolean isValid(char digit, int[] freq) {
        int num = digit - '0';
        return freq[num] == num;
    }


    // ------------ MAIN METHOD FOR TESTING ------------
    public static void main(String[] args) {
        FindValidAdjacentPair sol = new FindValidAdjacentPair();

        System.out.println(sol.findValidPair("2523533")); // Output: "23"
        System.out.println(sol.findValidPair("221"));     // Output: "21"
        System.out.println(sol.findValidPair("22"));      // Output: ""
    }
}
