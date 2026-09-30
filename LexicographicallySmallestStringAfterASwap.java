/**
 * Lexicographically Smallest String After a Swap
 *
 * Problem:
 * Given a string containing only digits, return the lexicographically
 * smallest string that can be obtained by swapping adjacent digits
 * at most once.
 *
 * The two adjacent digits can be swapped only when they have the
 * same parity:
 *
 * - Both digits are even, or
 * - Both digits are odd.
 *
 * Example:
 *
 * Input:
 * "45320"
 *
 * Output:
 * "43520"
 *
 * Explanation:
 * The adjacent digits '5' and '3' are both odd.
 * Swapping them gives:
 *
 * "45320" -> "43520"
 *
 * This is the lexicographically smaller result.
 *
 * Approach:
 * 1. Convert the string into a character array.
 * 2. Traverse the string from left to right.
 * 3. Check every pair of adjacent digits.
 * 4. If both digits have the same parity and the first digit
 *    is greater than the second digit, swap them.
 * 5. Stop after the first valid swap because only one swap
 *    is allowed.
 *
 * Why do we stop at the first valid swap?
 *
 * Lexicographical order is decided from left to right.
 * Therefore, making the earliest possible position smaller
 * gives the smallest possible string.
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 * because we use a character array.
 */
public class LexicographicallySmallestStringAfterASwap {

    /**
     * Returns the lexicographically smallest string after
     * at most one valid adjacent swap.
     *
     * @param s input string containing only digits
     * @return lexicographically smallest string
     */
    public static String getSmallestString(String s) {

        char[] arr = s.toCharArray();

        // Check every pair of adjacent digits.
        for (int i = 0; i < arr.length - 1; i++) {

            int firstDigit = arr[i] - '0';
            int secondDigit = arr[i + 1] - '0';

            // Check whether both digits have the same parity.
            boolean sameParity =
                    firstDigit % 2 == secondDigit % 2;

            // Swap only when the first digit is greater.
            if (sameParity && arr[i] > arr[i + 1]) {

                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

                // Only one swap is allowed.
                break;
            }
        }

        return new String(arr);
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        // Example 1
        String s1 = "45320";

        System.out.println("Example 1:");
        System.out.println("Input: " + s1);
        System.out.println("Output: " + getSmallestString(s1));

        System.out.println();

        // Example 2
        String s2 = "001";

        System.out.println("Example 2:");
        System.out.println("Input: " + s2);
        System.out.println("Output: " + getSmallestString(s2));

        System.out.println();

        // Example 3
        String s3 = "1234";

        System.out.println("Example 3:");
        System.out.println("Input: " + s3);
        System.out.println("Output: " + getSmallestString(s3));

        System.out.println();

        // Example 4
        String s4 = "8654";

        System.out.println("Example 4:");
        System.out.println("Input: " + s4);
        System.out.println("Output: " + getSmallestString(s4));
    }
}