/**
 * Problem: Find the Integer Added to Array I
 * Difficulty: Easy
 *
 * An integer x is added to every element of nums1
 * so that nums1 becomes equal to nums2.
 * Return the value of x.
 */

public class FindIntegerAddedToArray {

    public int addedInteger(int[] nums1, int[] nums2) {
        sortArray(nums1);
        sortArray(nums2);

        // Difference between smallest elements gives x
        return nums2[0] - nums1[0];
    }

    // Simple sorting method
    private void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        FindIntegerAddedToArray obj = new FindIntegerAddedToArray();

        int[] nums1 = {2, 6, 4};
        int[] nums2 = {9, 7, 5};
        System.out.println("Output: " + obj.addedInteger(nums1, nums2)); // 3

        int[] nums3 = {10};
        int[] nums4 = {5};
        System.out.println("Output: " + obj.addedInteger(nums3, nums4)); // -5

        int[] nums5 = {1, 1, 1, 1};
        int[] nums6 = {1, 1, 1, 1};
        System.out.println("Output: " + obj.addedInteger(nums5, nums6)); // 0
    }
}
