/**
 * Problem: Next Greater Element I
 * Difficulty: Easy
 *
 * For each element in nums1 (subset of nums2), find the next greater element in nums2.
 * If no such element exists, return -1 for that index.
 */

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int indexInNums2 = -1;

            // Step 1: Find the index of nums1[i] in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    indexInNums2 = j;
                    break;
                }
            }

            // Step 2: Find the next greater element
            int nextGreater = -1;
            for (int k = indexInNums2 + 1; k < nums2.length; k++) {
                if (nums2[k] > nums1[i]) {
                    nextGreater = nums2[k];
                    break;
                }
            }

            result[i] = nextGreater;
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] output1 = solution.nextGreaterElement(nums1, nums2);
        printArray(output1);  // Output: [-1, 3, -1]

        int[] nums3 = {2, 4};
        int[] nums4 = {1, 2, 3, 4};
        int[] output2 = solution.nextGreaterElement(nums3, nums4);
        printArray(output2);  // Output: [3, -1]
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
