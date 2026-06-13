/*
 add solution for calculating digit frequency score using frequency array
*/

/**
 * Problem: Digit Frequency Score
 * Difficulty: Easy
 *
 * Description:
 * The score of a number is defined as:
 *
 * Σ (digit × frequency of digit)
 *
 * for all digits present in the number.
 *
 * Return the score of the given integer.
 *
 * Key Insight:
 * - Count how many times each digit appears.
 * - Multiply each digit by its frequency.
 * - Add all contributions together.
 *
 * Approach:
 * - Create a frequency array of size 10.
 * - Extract digits using modulo (%) and division (/).
 * - Store digit frequencies.
 * - Calculate score using:
 *      digit × frequency
 * - Return the final score.
 *
 * Why this works:
 * The frequency array stores occurrences of every digit.
 * Summing digit × frequency directly follows the definition
 * of the score.
 *
 * Time Complexity: O(d)
 * d = number of digits in n
 *
 * Space Complexity: O(1)
 * Frequency array size is fixed (10).
 */
public class DigitFrequencyScore {

    public int digitFrequencyScore(int n) {

        int[] freq = new int[10];

        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }

        int score = 0;

        for (int digit = 0; digit <= 9; digit++) {
            score += digit * freq[digit];
        }

        return score;
    }

    public static void main(String[] args) {

        DigitFrequencyScore obj = new DigitFrequencyScore();

        // Example 1
        System.out.println(obj.digitFrequencyScore(122)); // 5

        // Example 2
        System.out.println(obj.digitFrequencyScore(101)); // 2
    }
}