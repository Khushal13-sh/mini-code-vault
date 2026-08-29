/*
 add solution for guess number higher or lower
*/

/**
 * Problem: Guess Number Higher or Lower
 * Difficulty: Easy
 *
 * Description:
 * We need to find a number picked between 1 and n.
 *
 * The guess(int num) method tells us whether our guess is:
 * - -1 if our guess is higher than the picked number
 * -  1 if our guess is lower than the picked number
 * -  0 if our guess is correct
 *
 * Key Insight:
 * - Use Binary Search to find the picked number.
 * - If the guess is too high, search the left half.
 * - If the guess is too low, search the right half.
 * - If the guess is correct, return it.
 *
 * Approach:
 * - Start with low = 1 and high = n.
 * - Find the middle value.
 * - Compare the middle value with the picked number.
 * - Adjust the search range accordingly.
 *
 * Time Complexity: O(log n)
 *
 * Space Complexity: O(1)
 */
public class GuessNumberHigherOrLower {

    // Simulates the picked number.
    private static int pick = 6;

    private static int guess(int num) {

        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        }

        return 0;
    }

    public static int guessNumber(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {

            // Calculate middle safely.
            int mid = low + (high - low) / 2;

            int result = guess(mid);

            if (result == 0) {

                // Correct guess.
                return mid;

            } else if (result == -1) {

                // Guess is higher than the picked number.
                high = mid - 1;

            } else {

                // Guess is lower than the picked number.
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n = 10;

        int result = guessNumber(n);

        System.out.println("Output: " + result);
    }
}