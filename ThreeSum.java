import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 *
 * Difficulty: Medium
 *
 * Problem:
 * Given an integer array nums, find all unique triplets
 * whose sum is equal to 0.
 *
 * Approach:
 * Sort the array and use the two-pointer technique.
 *
 * Key Idea:
 * Fix one element and use two pointers to find the other
 * two elements whose sum makes the total equal to 0.
 *
 * Time Complexity:
 * O(n^2)
 *
 * Space Complexity:
 * O(1) extra space, excluding the output.
 */
public class ThreeSum {

    /**
     * Finds all unique triplets whose sum is 0.
     *
     * @param nums input integer array
     * @return list of unique triplets
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        // Fix the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Found a valid triplet
                if (sum == 0) {

                    ans.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                    ));

                    // Skip duplicate values on the left
                    while (left < right
                            && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate values on the right
                    while (left < right
                            && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers
                    left++;
                    right--;

                } else if (sum < 0) {

                    // Sum is too small, increase left
                    left++;

                } else {

                    // Sum is too large, decrease right
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        ThreeSum obj = new ThreeSum();

        // Example 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};

        System.out.println("Input: "
                + Arrays.toString(nums1));

        System.out.println("Output: "
                + obj.threeSum(nums1));

        // Example 2
        int[] nums2 = {0, 1, 1};

        System.out.println("\nInput: "
                + Arrays.toString(nums2));

        System.out.println("Output: "
                + obj.threeSum(nums2));

        // Example 3
        int[] nums3 = {0, 0, 0};

        System.out.println("\nInput: "
                + Arrays.toString(nums3));

        System.out.println("Output: "
                + obj.threeSum(nums3));
    }
}