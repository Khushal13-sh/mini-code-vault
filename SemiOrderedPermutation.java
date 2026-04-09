/*
 add solution for semi ordered permutation using index positioning logic
*/

/**
 * Problem: Semi-Ordered Permutation
 * Difficulty: Easy
 *
 * Description:
 * A permutation is semi-ordered if 1 is at the beginning and n is at the end.
 * Find the minimum number of adjacent swaps required to achieve this.
 *
 * Approach:
 * - Find index of 1 → move it to index 0 → requires pos1 swaps
 * - Find index of n → move it to last index → requires (n - 1 - posN) swaps
 * - If 1 is to the right of n → one overlap swap occurs → subtract 1
 *
 * Why this works:
 * Swapping 1 left and n right may overlap if their paths cross.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SemiOrderedPermutation {

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int pos1 = 0, posN = 0;

        // Find positions of 1 and n
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) pos1 = i;
            if (nums[i] == n) posN = i;
        }

        int moves = pos1 + (n - 1 - posN);

        // Adjust if overlapping
        if (pos1 > posN) {
            moves--;
        }

        return moves;
    }

    public static void main(String[] args) {
        SemiOrderedPermutation obj = new SemiOrderedPermutation();

        // Example 1
        int[] nums1 = {2, 1, 4, 3};
        System.out.println("Output 1: " + obj.semiOrderedPermutation(nums1)); // 2

        // Example 2
        int[] nums2 = {2, 4, 1, 3};
        System.out.println("Output 2: " + obj.semiOrderedPermutation(nums2)); // 3

        // Example 3
        int[] nums3 = {1, 3, 4, 2, 5};
        System.out.println("Output 3: " + obj.semiOrderedPermutation(nums3)); // 0
    }
}