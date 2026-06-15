/*
 add solution for counting hills and valleys in an array
*/

/**
 * Problem: Count Hills and Valleys in an Array
 * Difficulty: Easy
 *
 * Description:
 * You are given an integer array nums.
 *
 * An index is part of a:
 * - Hill if its closest non-equal neighbors on both sides
 *   are smaller than it.
 * - Valley if its closest non-equal neighbors on both sides
 *   are larger than it.
 *
 * Consecutive equal values belong to the same hill or valley.
 *
 * Return the total number of hills and valleys.
 *
 * Key Insight:
 * - Consecutive duplicate values should be treated as one group.
 * - Remove adjacent duplicates first.
 * - Then check every middle element:
 *      Hill   -> greater than both neighbors
 *      Valley -> smaller than both neighbors
 *
 * Approach:
 * - Create a new list without consecutive duplicates.
 * - Traverse the compressed list from index 1 to size - 2.
 * - Count an element if it forms a hill or a valley.
 * - Return the count.
 *
 * Why this works:
 * After removing consecutive duplicates,
 * each hill or valley appears exactly once.
 * Checking neighboring elements is enough
 * to determine whether it is a hill or valley.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(n)
 * Extra list is used to store unique consecutive elements.
 */
public class CountHillsAndValleysInArray {

    public int countHillValley(int[] nums) {

        List<Integer> arr = new ArrayList<>();

        arr.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                arr.add(nums[i]);
            }
        }

        int count = 0;

        for (int i = 1; i < arr.size() - 1; i++) {

            boolean hill =
                    arr.get(i) > arr.get(i - 1)
                            && arr.get(i) > arr.get(i + 1);

            boolean valley =
                    arr.get(i) < arr.get(i - 1)
                            && arr.get(i) < arr.get(i + 1);

            if (hill || valley) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountHillsAndValleysInArray obj =
                new CountHillsAndValleysInArray();

        // Example 1
        int[] nums1 = {2, 4, 1, 1, 6, 5};

        System.out.println(
                "Output 1: " + obj.countHillValley(nums1)
        );

        // Example 2
        int[] nums2 = {6, 6, 5, 5, 4, 1};

        System.out.println(
                "Output 2: " + obj.countHillValley(nums2)
        );
    }
}