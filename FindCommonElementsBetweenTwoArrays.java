/*
 add solution for finding common elements between two arrays
*/

/**
 * Problem: Find Common Elements Between Two Arrays
 * Difficulty: Easy
 *
 * Description:
 * Given two integer arrays nums1 and nums2,
 * calculate:
 *
 * - answer1: Number of elements in nums1 that also exist in nums2.
 * - answer2: Number of elements in nums2 that also exist in nums1.
 *
 * Return the result as [answer1, answer2].
 *
 * Key Insight:
 * - For every element in nums1, check whether it exists in nums2.
 * - For every element in nums2, check whether it exists in nums1.
 * - Count each matching element only once per index.
 *
 * Approach:
 * - Traverse nums1 and search each element in nums2.
 * - If found, increment answer1 and stop searching for that element.
 * - Traverse nums2 and search each element in nums1.
 * - If found, increment answer2 and stop searching for that element.
 * - Return both counts.
 *
 * Why this works:
 * Each index is counted only when its value exists
 * somewhere in the other array.
 *
 * Time Complexity: O(n * m)
 * Each element of one array may be compared with
 * every element of the other array.
 *
 * Space Complexity: O(1)
 * Only two counters are used apart from the result array.
 */
public class FindCommonElementsBetweenTwoArrays {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    answer1++;
                    break;
                }
            }
        }

        for (int i = 0; i < nums2.length; i++) {

            for (int j = 0; j < nums1.length; j++) {

                if (nums2[i] == nums1[j]) {
                    answer2++;
                    break;
                }
            }
        }

        return new int[]{answer1, answer2};
    }

    public static void main(String[] args) {

        FindCommonElementsBetweenTwoArrays obj =
                new FindCommonElementsBetweenTwoArrays();

        // Example 1
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2};

        int[] result1 = obj.findIntersectionValues(nums1, nums2);

        System.out.println("Output 1: [" +
                result1[0] + ", " + result1[1] + "]");

        // Example 2
        int[] nums3 = {4, 3, 2, 3, 1};
        int[] nums4 = {2, 2, 5, 2, 3, 6};

        int[] result2 = obj.findIntersectionValues(nums3, nums4);

        System.out.println("Output 2: [" +
                result2[0] + ", " + result2[1] + "]");

        // Example 3
        int[] nums5 = {3, 4, 2, 3};
        int[] nums6 = {1, 5};

        int[] result3 = obj.findIntersectionValues(nums5, nums6);

        System.out.println("Output 3: [" +
                result3[0] + ", " + result3[1] + "]");
    }
}