/**
 * Problem: Find the Number of Good Pairs I
 * Difficulty: Easy
 *
 * A pair (i, j) is good if nums1[i] is divisible by nums2[j] * k.
 * Count and return the total number of such valid pairs.
 */

public class FindGoodPairs {

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;

        for (int num1 : nums1) {
            for (int num2 : nums2) {

                int product = num2 * k;

                if (num1 % product == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindGoodPairs solution = new FindGoodPairs();

        int[] nums1_1 = {1, 3, 4};
        int[] nums2_1 = {1, 3, 4};
        System.out.println(solution.numberOfPairs(nums1_1, nums2_1, 1)); 
        // Output: 5

        int[] nums1_2 = {1, 2, 4, 12};
        int[] nums2_2 = {2, 4};
        System.out.println(solution.numberOfPairs(nums1_2, nums2_2, 3)); 
        // Output: 2
    }
}
