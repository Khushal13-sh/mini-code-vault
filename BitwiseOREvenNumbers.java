/*
 add solution for bitwise OR of even numbers in array using bit manipulation
*/

/**
 * Problem: Bitwise OR of Even Numbers in an Array
 * Difficulty: Easy
 *
 * Description:
 * Return the bitwise OR of all even numbers in the array.
 * If no even numbers exist, return 0.
 *
 * Approach:
 * - Initialize result = 0
 * - Traverse the array
 * - If number is even → apply bitwise OR with result
 *
 * Why this works:
 * Bitwise OR accumulates all set bits from even numbers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BitwiseOREvenNumbers {

    public int evenNumberBitwiseORs(int[] nums) {

        int result = 0;

        for (int num : nums) {

            if (num % 2 == 0) {
                result |= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BitwiseOREvenNumbers obj = new BitwiseOREvenNumbers();

        // Example 1
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        System.out.println("Output 1: " + obj.evenNumberBitwiseORs(nums1)); // 6

        // Example 2
        int[] nums2 = {7, 9, 11};
        System.out.println("Output 2: " + obj.evenNumberBitwiseORs(nums2)); // 0

        // Example 3
        int[] nums3 = {1, 8, 16};
        System.out.println("Output 3: " + obj.evenNumberBitwiseORs(nums3)); // 24
    }
}