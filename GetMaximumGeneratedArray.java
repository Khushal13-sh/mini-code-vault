/**
 * Problem: Get Maximum in Generated Array
 * Difficulty: Easy
 *
 * Generate the nums array using given rules and return
 * the maximum value found in the generated array.
 */

public class GetMaximumGeneratedArray {

    public int getMaximumGenerated(int n) {

        // Base case: n = 0
        if (n == 0) {
            return 0;
        }

        int[] nums = new int[n + 1];

        nums[0] = 0;
        nums[1] = 1;

        int max = 1; // Track maximum

        int i = 1;
        while (i <= n / 2) {

            // Even index rule
            int evenIndex = 2 * i;
            if (evenIndex <= n) {
                nums[evenIndex] = nums[i];
                if (nums[evenIndex] > max) {
                    max = nums[evenIndex];
                }
            }

            // Odd index rule
            int oddIndex = 2 * i + 1;
            if (oddIndex <= n) {
                nums[oddIndex] = nums[i] + nums[i + 1];
                if (nums[oddIndex] > max) {
                    max = nums[oddIndex];
                }
            }

            i++;
        }

        return max;
    }

    // ---------- MAIN METHOD FOR TESTS ----------
    public static void main(String[] args) {
        GetMaximumGeneratedArray sol = new GetMaximumGeneratedArray();

        System.out.println(sol.getMaximumGenerated(7)); // 3
        System.out.println(sol.getMaximumGenerated(2)); // 1
        System.out.println(sol.getMaximumGenerated(3)); // 2
        System.out.println(sol.getMaximumGenerated(0)); // 0
        System.out.println(sol.getMaximumGenerated(10)); // should compute valid result
    }
}
