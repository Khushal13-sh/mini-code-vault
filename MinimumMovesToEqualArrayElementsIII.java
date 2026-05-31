/*
 add solution for minimum moves to equal array elements by making all elements equal to maximum
*/

/**
 * Problem: Minimum Moves to Equal Array Elements III
 * Difficulty: Easy
 *
 * Description:
 * In one move, you can increase any element by 1.
 *
 * Find the minimum number of moves required to make
 * all array elements equal.
 *
 * Key Insight:
 * Since we can only increase elements, the final value
 * must be at least the maximum element in the array.
 *
 * To minimize moves, make every element equal to the
 * current maximum element.
 *
 * Approach:
 * 1. Find the maximum element.
 * 2. For each element:
 *      moves += (max - element)
 * 3. Return total moves.
 *
 * Why this works:
 * Any target value greater than the maximum would require
 * additional unnecessary increments.
 *
 * Therefore, the maximum element is the optimal target.
 *
 * Time Complexity: O(n)
 * n = number of elements
 *
 * Space Complexity: O(1)
 */
public class MinimumMovesToEqualArrayElementsIII {

    public int minMoves(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int moves = 0;

        for (int num : nums) {
            moves += max - num;
        }

        return moves;
    }

    public static void main(String[] args) {

        MinimumMovesToEqualArrayElementsIII obj =
                new MinimumMovesToEqualArrayElementsIII();

        // Example 1
        int[] nums1 = {2, 1, 3};
        System.out.println("Output 1: " + obj.minMoves(nums1)); // 3

        // Example 2
        int[] nums2 = {4, 4, 5};
        System.out.println("Output 2: " + obj.minMoves(nums2)); // 2
    }
}