import java.util.*;

/**
 * Problem: Distribute Elements Into Two Arrays I
 * Difficulty: Easy
 *
 * Distribute elements into two arrays based on the comparison
 * of their last elements, then concatenate the arrays.
 */

public class DistributeElementsIntoTwoArrays {

    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // Initial distribution
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // Distribute remaining elements
        for (int i = 2; i < nums.length; i++) {
            int last1 = arr1.get(arr1.size() - 1);
            int last2 = arr2.get(arr2.size() - 1);

            if (last1 > last2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Combine both arrays
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : arr1) {
            result[index++] = num;
        }
        for (int num : arr2) {
            result[index++] = num;
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        DistributeElementsIntoTwoArrays obj = new DistributeElementsIntoTwoArrays();

        int[] nums1 = {2, 1, 3};
        System.out.println(Arrays.toString(obj.resultArray(nums1))); // [2, 3, 1]

        int[] nums2 = {5, 4, 3, 8};
        System.out.println(Arrays.toString(obj.resultArray(nums2))); // [5, 3, 4, 8]
    }
}
