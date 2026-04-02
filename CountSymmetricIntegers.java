/*
 add solution for count symmetric integers within range using string approach
*/

/**
 * Problem: Count Symmetric Integers
 * Difficulty: Easy
 *
 * Description:
 * Count how many integers in a given range have an even number of digits
 * and the sum of the first half digits equals the sum of the second half.
 *
 * Approach:
 * - Iterate from low to high
 * - Convert number to string
 * - Skip if length is odd
 * - Split into two halves
 * - Compare sum of both halves
 *
 * Example:
 * 1212 → left = 1+2 = 3, right = 1+2 = 3 → valid
 *
 * Time Complexity: O(n * d)
 * Space Complexity: O(d)
 */
public class CountSymmetricIntegers {

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            String s = String.valueOf(num);
            int len = s.length();

            // Skip odd length numbers
            if (len % 2 != 0) continue;

            int half = len / 2;
            int leftSum = 0, rightSum = 0;

            // Calculate sums of both halves
            for (int i = 0; i < half; i++) {
                leftSum += s.charAt(i) - '0';
                rightSum += s.charAt(i + half) - '0';
            }

            if (leftSum == rightSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountSymmetricIntegers obj = new CountSymmetricIntegers();

        // Example 1
        int low1 = 1, high1 = 100;
        System.out.println("Output 1: " + obj.countSymmetricIntegers(low1, high1)); // 9

        // Example 2
        int low2 = 1200, high2 = 1230;
        System.out.println("Output 2: " + obj.countSymmetricIntegers(low2, high2)); // 4
    }
}