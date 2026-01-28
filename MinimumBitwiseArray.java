import java.util.List;

/**
 * ------------------------------------------------------------
 * Class Name : MinimumBitwiseArray
 *
 * Description :
 * Constructs an array such that ans[i] OR (ans[i] + 1) equals
 * nums[i], while keeping ans[i] as small as possible.
 * If not possible, assigns -1.
 *
 * ------------------------------------------------------------
 */
public class MinimumBitwiseArray {

    /**
     * Returns the minimum bitwise array.
     */
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            // Even prime cannot be formed
            if ((x & 1) == 0) {
                ans[i] = -1;
            } else {
                // Find lowest set bit of (x + 1)
                int t = (x + 1) & -(x + 1);
                ans[i] = x - (t >> 1);
            }
        }
        return ans;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        MinimumBitwiseArray solution = new MinimumBitwiseArray();

        System.out.println(
            java.util.Arrays.toString(
                solution.minBitwiseArray(List.of(2, 3, 5, 7))
            )
        ); // [-1, 1, 4, 3]

        System.out.println(
            java.util.Arrays.toString(
                solution.minBitwiseArray(List.of(11, 13, 31))
            )
        ); // [9, 12, 15]
    }
}
