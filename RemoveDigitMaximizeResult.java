/*
 add solution for removing digit from number to maximize result using greedy string comparison
*/

/**
 * Problem: Remove Digit From Number to Maximize Result
 * Difficulty: Easy
 *
 * Description:
 * Remove exactly one occurrence of the given digit
 * from the number string such that the resulting
 * number becomes maximum.
 *
 * Key Insight:
 * - Try removing each occurrence of the digit
 * - Generate all possible candidate strings
 * - Keep the lexicographically largest string
 *
 * Approach:
 * - Traverse the string
 * - Whenever digit is found:
 *      - Remove that occurrence
 *      - Form new candidate string
 * - Compare with current maximum result
 * - Return the largest candidate
 *
 * Why this works:
 * Strings with equal length can be directly compared
 * lexicographically to determine larger numeric value.
 *
 * Time Complexity: O(n²)
 * - For every occurrence, substring creation takes O(n)
 *
 * Space Complexity: O(n)
 */
public class RemoveDigitMaximizeResult {

    public String removeDigit(String number, char digit) {

        String max = "";

        for (int i = 0; i < number.length(); i++) {

            // Check occurrence of target digit
            if (number.charAt(i) == digit) {

                // Remove current digit
                String candidate =
                        number.substring(0, i) +
                        number.substring(i + 1);

                // Update maximum result
                if (max.compareTo(candidate) < 0) {
                    max = candidate;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        RemoveDigitMaximizeResult obj =
                new RemoveDigitMaximizeResult();

        // Example 1
        System.out.println(
                "Output 1: " +
                obj.removeDigit("123", '3')
        ); // 12

        // Example 2
        System.out.println(
                "Output 2: " +
                obj.removeDigit("1231", '1')
        ); // 231

        // Example 3
        System.out.println(
                "Output 3: " +
                obj.removeDigit("551", '5')
        ); // 51
    }
}