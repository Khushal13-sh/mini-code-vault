/**
 * Problem: Count Subarrays of Length Three With a Condition
 * Difficulty: Easy
 *
 * Count subarrays of size 3 where:
 * (first element + third element) is exactly half of the middle element.
 */
public class CountSubarraysOfLengthThreeWithCondition {

    public int countSubarrays(int[] nums) {
        int count = 0;

        // Traverse till length - 3 to form subarrays of size 3
        for (int i = 0; i <= nums.length - 3; i++) {

            int first = nums[i];
            int middle = nums[i + 1];
            int third = nums[i + 2];

            // Check the given condition
            if (2 * (first + third) == middle) {
                count++;
            }
        }

        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        CountSubarraysOfLengthThreeWithCondition obj =
                new CountSubarraysOfLengthThreeWithCondition();

        System.out.println(obj.countSubarrays(
                new int[]{1, 2, 1, 4, 1})); // 1

        System.out.println(obj.countSubarrays(
                new int[]{1, 1, 1})); // 0
    }
}
