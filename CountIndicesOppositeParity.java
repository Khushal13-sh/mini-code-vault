/*
 add solution for counting indices with opposite parity using reverse traversal
*/

/**
 * Problem: Count Indices With Opposite Parity
 * Difficulty: Easy
 *
 * Description:
 * For every index i, find how many indices j exist such that:
 * - i < j < n
 * - nums[i] and nums[j] have different parity
 *
 * Return the score for every index.
 *
 * Key Insight:
 * - We only care about:
 *      total even numbers to the right
 *      total odd numbers to the right
 *
 * - If current number is even:
 *      answer = oddCount
 *
 * - If current number is odd:
 *      answer = evenCount
 *
 * Approach:
 * - Traverse array from right to left
 * - Maintain:
 *      evenCount
 *      oddCount
 *
 * - For each element:
 *      - if even → score = oddCount
 *      - if odd  → score = evenCount
 *
 * - Update parity counters
 *
 * Why this works:
 * Reverse traversal helps us maintain
 * counts of elements to the right efficiently.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * (excluding output array)
 */
public class CountIndicesOppositeParity {

    public int[] countOppositeParity(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        int evenCount = 0;
        int oddCount = 0;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Current number is even
            if (nums[i] % 2 == 0) {

                answer[i] = oddCount;

                evenCount++;
            }

            // Current number is odd
            else {

                answer[i] = evenCount;

                oddCount++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        CountIndicesOppositeParity obj =
                new CountIndicesOppositeParity();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};

        int[] result1 =
                obj.countOppositeParity(nums1);

        System.out.print("Output 1: ");

        for (int num : result1) {
            System.out.print(num + " ");
        }
        // 2 1 1 0

        System.out.println();

        // Example 2
        int[] nums2 = {1};

        int[] result2 =
                obj.countOppositeParity(nums2);

        System.out.print("Output 2: ");

        for (int num : result2) {
            System.out.print(num + " ");
        }
        // 0
    }
}