/*
 add solution for make two arrays equal by reversing subarrays using frequency counting
*/

/**
 * Problem: Make Two Arrays Equal by Reversing Subarrays
 * Difficulty: Easy
 *
 * Description:
 * Check whether array arr can be converted into target
 * using any number of subarray reversals.
 *
 * Key Insight:
 * - Reversing subarrays allows rearranging elements in any order
 * - Therefore, both arrays must contain the same frequencies
 *   of elements
 *
 * Approach:
 * - Create a frequency array
 * - Increment count for elements in target
 * - Decrement count for elements in arr
 * - If all frequencies become zero, arrays can be made equal
 *
 * Why this works:
 * Any permutation can be achieved through subarray reversals.
 * So only element frequencies matter.
 *
 * Time Complexity: O(n)
 * n = length of arrays
 *
 * Space Complexity: O(1)
 * Frequency array size is fixed (1001)
 */
public class MakeTwoArraysEqual {

    public boolean canBeEqual(int[] target, int[] arr) {

        int[] count = new int[1001];

        for (int i = 0; i < target.length; i++) {
            count[target[i]]++;
            count[arr[i]]--;
        }

        for (int i = 0; i < 1001; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        MakeTwoArraysEqual obj = new MakeTwoArraysEqual();

        // Example 1
        int[] target1 = {1, 2, 3, 4};
        int[] arr1 = {2, 4, 1, 3};

        System.out.println(
                "Output 1: " +
                obj.canBeEqual(target1, arr1)
        ); // true

        // Example 2
        int[] target2 = {7};
        int[] arr2 = {7};

        System.out.println(
                "Output 2: " +
                obj.canBeEqual(target2, arr2)
        ); // true

        // Example 3
        int[] target3 = {3, 7, 9};
        int[] arr3 = {3, 7, 11};

        System.out.println(
                "Output 3: " +
                obj.canBeEqual(target3, arr3)
        ); // false
    }
}