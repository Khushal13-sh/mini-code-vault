/**
 * Problem: Find if Digit Game Can Be Won
 * Difficulty: Easy
 *
 * Alice chooses either all single-digit numbers or all double-digit numbers.
 * She wins if the sum of the chosen group is strictly greater than the sum
 * of the remaining numbers.
 */

public class CanAliceWinGame {

    public boolean canAliceWin(int[] nums) {

        int singleSum = 0;   // Sum of 0–9
        int doubleSum = 0;   // Sum of 10–99

        // Separate sums
        for (int n : nums) {
            if (n >= 0 && n <= 9) {
                singleSum += n;
            } else if (n >= 10 && n <= 99) {
                doubleSum += n;
            }
        }

        int total = singleSum + doubleSum;

        // Check if choosing single-digit gives a win
        if (singleSum > (total - singleSum)) {
            return true;
        }

        // Check if choosing double-digit gives a win
        if (doubleSum > (total - doubleSum)) {
            return true;
        }

        return false;
    }

    // ------------ MAIN METHOD FOR TESTING ------------
    public static void main(String[] args) {

        CanAliceWinGame sol = new CanAliceWinGame();

        // Example test cases
        System.out.println(sol.canAliceWin(new int[]{1, 2, 3, 4, 10}));    // false
        System.out.println(sol.canAliceWin(new int[]{1, 2, 3, 4, 5, 14})); // true
        System.out.println(sol.canAliceWin(new int[]{5, 5, 5, 25}));       // true
        System.out.println(sol.canAliceWin(new int[]{9, 9, 9}));           // true
        System.out.println(sol.canAliceWin(new int[]{12, 13, 14}));        // true
    }
}
