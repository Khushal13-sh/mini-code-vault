/**
 * Problem: Sum of Variable Length Subarrays
 * Difficulty: Easy
 *
 * For each index i, define subarray nums[start...i] where start = max(0, i - nums[i]).
 * Return the total sum of all such subarrays.
 */
public class SumOfVariableLengthSubarrays {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        long total = 0;
        long prefixSum = 0;
        long[] prefix = new long[n];

        // Compute prefix sums for quick subarray calculations
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            prefix[i] = prefixSum;
        }

        // Calculate subarray sums for each index
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            long subSum = prefix[i] - (start > 0 ? prefix[start - 1] : 0);
            total += subSum;
        }

        return (int) total;
    }

    // --- test ---
    public static void main(String[] args) {
        SumOfVariableLengthSubarrays sol = new SumOfVariableLengthSubarrays();
        System.out.println(sol.subarraySum(new int[]{2, 3, 1}));   // 11
        System.out.println(sol.subarraySum(new int[]{3, 1, 1, 2})); // 13
        System.out.println(sol.subarraySum(new int[]{1, 2, 3}));   // 10
    }
}
