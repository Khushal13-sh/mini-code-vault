
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Subsets II
 * LeetCode: 90
 * Difficulty: Medium
 *
 * Description:
 * Given an integer array that may contain duplicates,
 * return all possible subsets without duplicate subsets.
 *
 * Approach:
 * Backtracking with Sorting.
 *
 * We sort the array so duplicate elements are adjacent.
 * During recursion, we skip duplicate elements at the
 * same recursion level to avoid generating duplicate subsets.
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Stores all unique subsets.
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to place duplicate elements together.
        Arrays.sort(nums);

        // Start generating subsets from index 0.
        List<Integer> current = new ArrayList<>();

        findSubsets(nums, 0, current, result);

        return result;
    }

    /**
     * Recursively generates all unique subsets.
     *
     * @param nums    Sorted input array.
     * @param index   Starting index for the current recursion.
     * @param current Subset currently being generated.
     * @param result  Stores all generated subsets.
     */
    private void findSubsets(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Add a copy of the current subset.
        // A copy is necessary because current will be modified
        // during subsequent recursive calls.
        result.add(new ArrayList<>(current));

        // Explore all possible elements from the current index.
        for (int i = index; i < nums.length; i++) {

            /*
             * Skip duplicate elements at the same recursion level.
             *
             * i > index ensures that we skip only duplicates
             * encountered in the current loop.
             *
             * This still allows choosing the same value again
             * at a deeper recursion level.
             */
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose the current element.
            current.add(nums[i]);

            // Generate subsets using the next index.
            // i + 1 ensures that each array element is used once.
            findSubsets(nums, i + 1, current, result);

            // Backtrack: remove the last selected element.
            // This allows exploring another possible subset.
            current.remove(current.size() - 1);
        }
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        SubsetsII solution = new SubsetsII();

        // Test Case 1
        int[] nums1 = {1, 2, 2};

        System.out.println("Input: [1, 2, 2]");
        System.out.println("Output: " + solution.subsetsWithDup(nums1));

        // Test Case 2
        int[] nums2 = {0};

        System.out.println("\nInput: [0]");
        System.out.println("Output: " + solution.subsetsWithDup(nums2));

        // Test Case 3
        int[] nums3 = {1, 2, 2, 3};

        System.out.println("\nInput: [1, 2, 2, 3]");
        System.out.println("Output: " + solution.subsetsWithDup(nums3));

        // Test Case 4: All elements are duplicates
        int[] nums4 = {2, 2, 2};

        System.out.println("\nInput: [2, 2, 2]");
        System.out.println("Output: " + solution.subsetsWithDup(nums4));
    }
}
