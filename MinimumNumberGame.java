/**
 * Problem: Minimum Number Game
 * Difficulty: Easy
 *
 * Description:
 * You are given an integer array nums of even length. Alice and Bob play a game with the following rules:
 *
 * 1. In each round:
 *    - Alice removes the minimum element from nums.
 *    - Bob removes the next minimum element from nums.
 * 2. They both append the removed elements into a new array arr:
 *    - First Bob appends his removed element.
 *    - Then Alice appends her removed element.
 * 3. The game continues until nums becomes empty.
 *
 * Task:
 * Return the resulting array arr.
 *
 * Example 1:
 * Input: nums = [5,4,2,3]
 * Output: [3,2,5,4]
 *
 * Example 2:
 * Input: nums = [2,5]
 * Output: [5,2]
 *
 * Constraints:
 * - 2 <= nums.length <= 100
 * - 1 <= nums[i] <= 100
 * - nums.length is even
 *
 * Approach:
 * 1. Sort the array (using custom selection sort method here).
 * 2. Swap elements in pairs so that Bob's pick (second-smallest) comes first, then Alice's pick (smallest).
 * 3. Repeat until array is filled.
 *
 * Time Complexity: O(n^2) (due to selection sort) → acceptable for n <= 100.
 * Space Complexity: O(1) extra space (in-place sorting).
 */

public class MinimumNumberGame {

    /**
     * Main method that performs the game and returns result array.
     */
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        // Step 1: Sort array manually (selection sort)
        sortArray(nums);

        // Step 2: Arrange elements in pairs
        for (int i = 0; i < n; i += 2) {
            arr[i] = nums[i + 1];  // Bob appends first
            arr[i + 1] = nums[i];  // Alice appends next
        }

        return arr;
    }

    /**
     * Custom selection sort method to sort array.
     */
    private void sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    /**
     * Main method to test solution.
     */
    public static void main(String[] args) {
        MinimumNumberGame solution = new MinimumNumberGame();

        int[] nums1 = {5, 4, 2, 3};
        int[] result1 = solution.numberGame(nums1);
        System.out.print("Output [5,4,2,3] → ");
        for (int x : result1) System.out.print(x + " "); // Expected: 3 2 5 4
        System.out.println();

        int[] nums2 = {2, 5};
        int[] result2 = solution.numberGame(nums2);
        System.out.print("Output [2,5] → ");
        for (int x : result2) System.out.print(x + " "); // Expected: 5 2
        System.out.println();
    }
}
