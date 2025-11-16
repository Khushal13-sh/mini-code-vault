/**
 * Problem: Check Balanced String
 * Difficulty: Easy
 *
 * A string of digits is considered balanced if:
 *   sum of digits at even indices == sum of digits at odd indices.
 *
 * Approach:
 * - Traverse through characters
 * - Convert each to digit
 * - Add to evenSum or oddSum based on index
 * - Finally compare the sums
 */

public class CheckBalancedString {

    public boolean isBalanced(String num) {
        int evenSum = 0;
        int oddSum = 0;

        // Traverse each digit
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';

            if ((i % 2) == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }

        return evenSum == oddSum;
    }

    // ------- MAIN METHOD WITH EXAMPLES -------
    public static void main(String[] args) {
        CheckBalancedString sol = new CheckBalancedString();

        System.out.println(sol.isBalanced("1234"));   // false
        System.out.println(sol.isBalanced("24123"));  // true
        System.out.println(sol.isBalanced("11"));     // true
        System.out.println(sol.isBalanced("135"));    // false
    }
}
