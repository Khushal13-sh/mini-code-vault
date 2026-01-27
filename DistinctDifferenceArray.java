import java.util.HashSet;
import java.util.Set;

/**
 * ------------------------------------------------------------
 * Class Name : DistinctDifferenceArray
 *
 * Description :
 * For each index, calculates the difference between the number
 * of distinct elements in the prefix and the suffix of the array.
 *
 * ------------------------------------------------------------
 */
public class DistinctDifferenceArray {

    /**
     * Returns the distinct difference array.
     */
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];

        int[] suffixDistinct = new int[n];
        Set<Integer> suffixSet = new HashSet<>();

        // Count distinct elements in suffix
        for (int i = n - 1; i >= 0; i--) {
            suffixSet.add(nums[i]);
            suffixDistinct[i] = suffixSet.size();
        }

        Set<Integer> prefixSet = new HashSet<>();

        // Calculate prefix - suffix difference
        for (int i = 0; i < n; i++) {
            prefixSet.add(nums[i]);
            int prefixCount = prefixSet.size();
            int suffixCount = (i + 1 < n) ? suffixDistinct[i + 1] : 0;
            diff[i] = prefixCount - suffixCount;
        }

        return diff;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        DistinctDifferenceArray solution = new DistinctDifferenceArray();

        int[] nums1 = {1, 2, 3, 4, 5};
        printArray(solution.distinctDifferenceArray(nums1)); // [-3,-1,1,3,5]

        int[] nums2 = {3, 2, 3, 4, 2};
        printArray(solution.distinctDifferenceArray(nums2)); // [-2,-1,0,2,3]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
