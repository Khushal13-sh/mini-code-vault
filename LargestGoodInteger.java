/**
 * Problem: Largest 3-Same-Digit Number in String
 * Difficulty: Easy
 *
 * Description:
 * You are given a string `num` representing a large integer.
 * An integer is considered "good" if:
 * 1. It is a substring of `num` with length exactly 3.
 * 2. All three characters are the same digit.
 *
 * Task:
 * Return the maximum good integer as a string.
 * If no such integer exists, return an empty string "".
 *
 * Example:
 * Input: num = "6777133339" → Output: "777"
 * Input: num = "2300019" → Output: "000"
 * Input: num = "42352338" → Output: ""
 *
 * Approach:
 * - Use a sliding window of size 3.
 * - Check if all characters are the same.
 * - Keep track of the largest found so far.
 *
 * Time Complexity: O(n)  [n = num.length]
 * Space Complexity: O(1)
 */

public class LargestGoodInteger {

    /**
     * Finds the largest 3-same-digit substring in a given number string.
     *
     * @param num The input number as a string
     * @return The largest good integer as a string, or "" if none exists
     */
    public String largestGoodInteger(String num) {
        String largestTriple = "";
        StringBuilder tripleBuilder = new StringBuilder();

        for (int i = 0; i <= num.length() - 3; i++) {
            tripleBuilder.setLength(0);
            tripleBuilder.append(num.charAt(i))
                         .append(num.charAt(i + 1))
                         .append(num.charAt(i + 2));

            if (tripleBuilder.charAt(0) == tripleBuilder.charAt(1) &&
                tripleBuilder.charAt(1) == tripleBuilder.charAt(2)) {

                String currentTriple = tripleBuilder.toString();
                if (largestTriple.isEmpty() || currentTriple.compareTo(largestTriple) > 0) {
                    largestTriple = currentTriple;
                }
            }
        }
        return largestTriple;
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        LargestGoodInteger solution = new LargestGoodInteger();

        System.out.println(solution.largestGoodInteger("6777133339")); // Output: 777
        System.out.println(solution.largestGoodInteger("2300019"));    // Output: 000
        System.out.println(solution.largestGoodInteger("42352338"));   // Output: 
    }
}
