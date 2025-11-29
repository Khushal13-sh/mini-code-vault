/**
 * Problem: Maximum Subarray With Equal Products
 * Difficulty: Easy
 *
 * A subarray is product-equivalent if:
 * product(arr) == gcd(arr) * lcm(arr)
 *
 * Goal: Return the length of the longest product-equivalent subarray.
 */

public class MaximumSubarrayEqualProducts {

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            int g = 0;
            int l = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                g = (g == 0) ? nums[j] : gcd(g, nums[j]);
                l = lcm(l, nums[j]);

                if (prod == (long) g * l) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        MaximumSubarrayEqualProducts solution = new MaximumSubarrayEqualProducts();

        // Test cases
        System.out.println(solution.maxLength(new int[]{1,2,1,2,1,1,1})); // Expected: 5
        System.out.println(solution.maxLength(new int[]{2,3,4,5,6}));     // Expected: 3
        System.out.println(solution.maxLength(new int[]{1,2,3,1,4,5,1})); // Expected: 5
    }
}
