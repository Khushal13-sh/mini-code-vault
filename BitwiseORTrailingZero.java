/*
 add solution for checking trailing zero in bitwise OR using even count logic
*/

/**
 * Problem: Check if Bitwise OR Has Trailing Zeros
 * Difficulty: Easy
 *
 * Description:
 * Determine if we can pick at least two numbers such that
 * their bitwise OR has at least one trailing zero.
 *
 * Key Insight:
 * - A trailing zero means the last bit is 0
 * - OR operation gives last bit 0 only if all selected numbers have last bit 0
 * - That means numbers must be EVEN
 *
 * Approach:
 * - Count how many even numbers exist
 * - If count ≥ 2 → possible
 *
 * Why this works:
 * Even numbers have last bit = 0, so OR of at least two evens keeps last bit 0.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BitwiseORTrailingZero {

    public boolean hasTrailingZeros(int[] nums) {

        int evenCount = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        return evenCount >= 2;
    }

    public static void main(String[] args) {
        BitwiseORTrailingZero obj = new BitwiseORTrailingZero();

        // Example 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Output 1: " + obj.hasTrailingZeros(nums1)); // true

        // Example 2
        int[] nums2 = {2, 4, 8, 16};
        System.out.println("Output 2: " + obj.hasTrailingZeros(nums2)); // true

        // Example 3
        int[] nums3 = {1, 3, 5, 7, 9};
        System.out.println("Output 3: " + obj.hasTrailingZeros(nums3)); // false
    }
}