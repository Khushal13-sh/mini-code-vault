import java.util.Arrays;

/**
 * Next Permutation
 *
 * Difficulty: Medium
 *
 * Problem:
 * Rearrange the array into the next lexicographically greater
 * permutation.
 *
 * If no greater permutation exists, rearrange the array into
 * ascending order.
 *
 * Approach:
 * 1. Find the pivot from the right.
 * 2. Find the next greater element from the right.
 * 3. Swap the pivot and the next greater element.
 * 4. Reverse the suffix.
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 */
public class NextPermutation {

    /**
     * Rearranges nums into its next permutation.
     *
     * @param nums input array
     */
    public void nextPermutation(int[] nums) {

        // Step 1: Find the first decreasing element from the right
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If a pivot exists
        if (i >= 0) {

            // Find the first element from the right
            // that is greater than the pivot
            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap pivot and next greater element
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix
        // This also handles the case where no pivot exists
        reverse(nums, i + 1, nums.length - 1);
    }

    /**
     * Swaps two elements in the array.
     */
    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Reverses the array between left and right indexes.
     */
    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        NextPermutation obj = new NextPermutation();

        // Example 1
        int[] nums1 = {1, 2, 3};

        obj.nextPermutation(nums1);

        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + Arrays.toString(nums1));

        // Example 2
        int[] nums2 = {3, 2, 1};

        obj.nextPermutation(nums2);

        System.out.println("\nInput: [3, 2, 1]");
        System.out.println("Output: " + Arrays.toString(nums2));

        // Example 3
        int[] nums3 = {1, 1, 5};

        obj.nextPermutation(nums3);

        System.out.println("\nInput: [1, 1, 5]");
        System.out.println("Output: " + Arrays.toString(nums3));
    }
}