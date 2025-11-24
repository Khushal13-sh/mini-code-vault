/**
 * Problem: Find the K-or of an Array
 * Difficulty: Easy
 *
 * A bit is set in the final result only if at least 'k' elements in the array
 * have that bit set. We check all 32 bits for every number in the array.
 */

public class FindKOr {

    public int findKOr(int[] nums, int k) {
        int result = 0;

        // Check all 32 bits
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            // Count how many numbers have this bit set
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // If at least k numbers contain this bit → include it
            if (count >= k) {
                result |= (1 << bit);
            }
        }

        return result;
    }

    // ------------ MAIN METHOD FOR TESTS ------------
    public static void main(String[] args) {
        FindKOr sol = new FindKOr();

        int[] nums1 = {7, 12, 9, 8, 9, 15};
        int k1 = 4;

        int[] nums2 = {2, 12, 1, 11, 4, 5};
        int k2 = 6;

        int[] nums3 = {10, 8, 5, 9, 11, 6, 8};
        int k3 = 1;

        System.out.println(sol.findKOr(nums1, k1)); // 9
        System.out.println(sol.findKOr(nums2, k2)); // 0
        System.out.println(sol.findKOr(nums3, k3)); // 15
    }
}
