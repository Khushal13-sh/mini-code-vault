import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 *
 * Difficulty: Medium
 *
 * Problem:
 * Given a string containing digits from 2 to 9,
 * return all possible letter combinations that
 * the digits could represent.
 *
 * Approach:
 * Backtracking
 *
 * Key Idea:
 * For every digit, try each possible letter and
 * recursively process the next digit.
 *
 * Time Complexity:
 * O(4^n * n)
 *
 * Space Complexity:
 * O(n) excluding the output.
 */
public class LetterCombinationsOfAPhoneNumber {

    // Phone keypad mapping
    private String[] map = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    /**
     * Returns all possible letter combinations.
     *
     * @param digits input digit string
     * @return list of all possible combinations
     */
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        // Handle empty input
        if (digits.length() == 0) {
            return result;
        }

        // Start backtracking from the first digit
        backtrack(digits, 0, "", result);

        return result;
    }

    /**
     * Generates combinations using backtracking.
     *
     * @param digits original digit string
     * @param i current digit index
     * @param current current combination
     * @param result final result list
     */
    private void backtrack(
            String digits,
            int i,
            String current,
            List<String> result) {

        // All digits have been processed
        if (i == digits.length()) {
            result.add(current);
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = map[digits.charAt(i) - '0'];

        // Try every possible letter
        for (char c : letters.toCharArray()) {

            // Add the letter and process the next digit
            backtrack(
                    digits,
                    i + 1,
                    current + c,
                    result
            );
        }
    }

    public static void main(String[] args) {

        LetterCombinationsOfAPhoneNumber obj =
                new LetterCombinationsOfAPhoneNumber();

        // Example 1
        String digits1 = "23";

        System.out.println("Input: " + digits1);
        System.out.println(
                "Output: " + obj.letterCombinations(digits1)
        );

        // Example 2
        String digits2 = "2";

        System.out.println("\nInput: " + digits2);
        System.out.println(
                "Output: " + obj.letterCombinations(digits2)
        );
    }
}