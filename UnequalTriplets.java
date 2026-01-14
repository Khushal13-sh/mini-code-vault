/**
 * Problem: Number of Unequal Triplets in Array
 * Difficulty: Easy
 *
 * Count the number of triplets (i, j, k) such that:
 * i < j < k and nums[i], nums[j], nums[k] are pairwise distinct.
 */
public class UnequalTriplets {

    public int unequalTriplets(int[] nums) {

        int n = nums.length;
        int count = 0;

        // Check all possible triplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (nums[i] != nums[j] &&
                        nums[i] != nums[k] &&
                        nums[j] != nums[k]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        UnequalTriplets obj = new UnequalTriplets();

        System.out.println(obj.unequalTriplets(
                new int[]{4, 4, 2, 4, 3})); // 3

        System.out.println(obj.unequalTriplets(
                new int[]{1, 1, 1, 1, 1})); // 0
    }
}
