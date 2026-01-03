/**
 * Problem: Max Pair Sum in an Array
 * Difficulty: Easy
 *
 * Find the maximum sum of a pair of numbers
 * such that both numbers have the same largest digit.
 */
public class MaxPairSumInAnArray {

    public int maxSum(int[] nums) {
        // max[d][0] -> largest number with max digit d
        // max[d][1] -> second largest number with max digit d
        int[][] max = new int[10][2];

        for (int n : nums) {
            int d = maxDigit(n);

            if (n > max[d][0]) {
                max[d][1] = max[d][0];
                max[d][0] = n;
            } else if (n > max[d][1]) {
                max[d][1] = n;
            }
        }

        int result = -1;
        for (int i = 0; i < 10; i++) {
            if (max[i][1] > 0) {
                result = Math.max(result, max[i][0] + max[i][1]);
            }
        }

        return result;
    }

    // Helper method to find the largest digit of a number
    private int maxDigit(int n) {
        int d = 0;
        while (n > 0) {
            d = Math.max(d, n % 10);
            n /= 10;
        }
        return d;
    }

    // Main method for testing
    public static void main(String[] args) {
        MaxPairSumInAnArray obj =
                new MaxPairSumInAnArray();

        System.out.println(obj.maxSum(new int[]{112,131,411})); // -1
        System.out.println(obj.maxSum(new int[]{2536,1613,3366,162})); // 5902
        System.out.println(obj.maxSum(new int[]{51,71,17,24,42})); // 88
    }
}
