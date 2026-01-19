/**
 * Problem: Find the K-Beauty of a Number
 * Difficulty: Easy
 *
 * The k-beauty of a number is the count of substrings
 * of length k that are divisors of the given number.
 *
 * Notes:
 * - Leading zeros are allowed
 * - 0 is NOT a valid divisor
 *
 * Examples:
 *
 * Example 1:
 * Input: num = 240, k = 2
 * Output: 2
 * Explanation:
 * Substrings: "24", "40"
 * 24 divides 240 ✔
 * 40 divides 240 ✔
 *
 * Example 2:
 * Input: num = 430043, k = 2
 * Output: 2
 * Explanation:
 * Substrings: "43", "30", "00", "04", "43"
 * Valid divisors: 43, 43
 */
public class FindKBeautyOfNumber {

    public int divisorSubstrings(int num, int k) {

        String str = String.valueOf(num);
        int count = 0;

        // Traverse all substrings of length k
        for (int i = 0; i <= str.length() - k; i++) {

            String sub = str.substring(i, i + k);
            int value = Integer.parseInt(sub);

            // Check divisor condition
            if (value != 0 && num % value == 0) {
                count++;
            }
        }

        return count;
    }

    // Main method with example test cases
    public static void main(String[] args) {

        FindKBeautyOfNumber solution = new FindKBeautyOfNumber();

        // Example 1
        int num1 = 240;
        int k1 = 2;
        System.out.println("Example 1 Output: " +
                solution.divisorSubstrings(num1, k1));

        // Example 2
        int num2 = 430043;
        int k2 = 2;
        System.out.println("Example 2 Output: " +
                solution.divisorSubstrings(num2, k2));
    }
}
