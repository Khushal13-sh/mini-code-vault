/*
 add solution for longest subsequence with limited sum using sorting, prefix sum and binary search
*/

/**
 * Problem: Longest Subsequence With Limited Sum
 * Difficulty: Easy
 *
 * Description:
 * For each query, find the maximum size of a subsequence
 * such that the sum is ≤ query value.
 *
 * Key Insight:
 * - To maximize length → always pick smallest elements first
 * - So, sort the array
 * - Build prefix sum
 * - Use binary search to find max valid length
 *
 * Approach:
 * 1. Sort nums
 * 2. Build prefix sum array
 * 3. For each query:
 *      → find largest index where prefix[i] ≤ query
 *      → answer = i + 1
 *
 * Why this works:
 * Greedy + prefix sum ensures minimum sum for maximum length.
 *
 * Time Complexity:
 * O(n log n + m log n)
 *
 * Space Complexity:
 * O(n)
 */
public class LongestSubsequenceLimitedSum {

    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);

        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = upperBound(prefix, queries[i]);
        }

        return answer;
    }

    private int upperBound(int[] prefix, int target) {

        int left = 0, right = prefix.length - 1;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] <= target) {
                res = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestSubsequenceLimitedSum obj = new LongestSubsequenceLimitedSum();

        // Example 1
        int[] nums1 = {4, 5, 2, 1};
        int[] queries1 = {3, 10, 21};
        System.out.println(Arrays.toString(obj.answerQueries(nums1, queries1))); // [2,3,4]

        // Example 2
        int[] nums2 = {2, 3, 4, 5};
        int[] queries2 = {1};
        System.out.println(Arrays.toString(obj.answerQueries(nums2, queries2))); // [0]
    }
}