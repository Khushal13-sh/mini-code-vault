
/*
 * Problem: Maximum Gap
 * LeetCode: 164
 * Difficulty: Medium
 *
 * Approach: Bucket Sort
 *
 * Instead of sorting the complete array, divide the range
 * between the minimum and maximum values into buckets.
 *
 * For every bucket, maintain:
 * 1. Minimum element.
 * 2. Maximum element.
 * 3. Whether the bucket contains any element.
 *
 * After distributing all elements, compare the minimum
 * of the current non-empty bucket with the maximum of
 * the previous non-empty bucket.
 *
 * The largest difference is the maximum gap.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class MaximumGap {

    public int maximumGap(int[] nums) {

        int n = nums.length;

        // If there are fewer than two elements,
        // no gap can be calculated.
        if (n < 2) {
            return 0;
        }

        // Find the minimum and maximum values.
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {

            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // If all elements are equal, maximum gap is zero.
        if (min == max) {
            return 0;
        }

        // Calculate the bucket size.
        int bucketSize = (max - min) / (n - 1);

        // Ensure that bucket size is at least one.
        if (bucketSize == 0) {
            bucketSize = 1;
        }

        // Calculate the total number of buckets.
        int bucketCount = ((max - min) / bucketSize) + 1;

        // Store the minimum and maximum of each bucket.
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        // Track whether each bucket contains elements.
        boolean[] used = new boolean[bucketCount];

        // Initialize bucket minimums and maximums.
        for (int i = 0; i < bucketCount; i++) {

            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }

        // Distribute every number into its bucket.
        for (int num : nums) {

            // Calculate the bucket index.
            int index = (num - min) / bucketSize;

            // Update the minimum value of this bucket.
            if (num < bucketMin[index]) {
                bucketMin[index] = num;
            }

            // Update the maximum value of this bucket.
            if (num > bucketMax[index]) {
                bucketMax[index] = num;
            }

            // Mark this bucket as occupied.
            used[index] = true;
        }

        int maxGap = 0;

        // Initially, the previous maximum is the array minimum.
        int previousMax = min;

        // Calculate gaps between consecutive non-empty buckets.
        for (int i = 0; i < bucketCount; i++) {

            // Ignore empty buckets.
            if (!used[i]) {
                continue;
            }

            // Gap between the current bucket and previous bucket.
            int gap = bucketMin[i] - previousMax;

            // Update the maximum gap.
            if (gap > maxGap) {
                maxGap = gap;
            }

            // Store the current bucket's maximum.
            previousMax = bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {

        MaximumGap solution = new MaximumGap();

        // Test Case 1
        int[] nums1 = {3, 6, 9, 1};

        System.out.println(
            solution.maximumGap(nums1)
        ); // 3

        // Test Case 2
        int[] nums2 = {10};

        System.out.println(
            solution.maximumGap(nums2)
        ); // 0

        // Test Case 3: All elements are equal.
        int[] nums3 = {5, 5, 5, 5};

        System.out.println(
            solution.maximumGap(nums3)
        ); // 0

        // Test Case 4: Maximum gap at the end.
        int[] nums4 = {1, 2, 3, 100};

        System.out.println(
            solution.maximumGap(nums4)
        ); // 97

        // Test Case 5
        int[] nums5 = {1, 1000000000};

        System.out.println(
            solution.maximumGap(nums5)
        ); // 999999999
    }
}
