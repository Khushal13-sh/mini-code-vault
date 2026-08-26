/*
 add solution for find all k-distant indices in an array
*/

/**
 * Problem: Find All K-Distant Indices in an Array
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, an integer key, and an integer k,
 * find all indices i such that there exists an index j where:
 *
 * nums[j] == key
 * |i - j| <= k
 *
 * Return all such indices in increasing order.
 *
 * Key Insight:
 * - For every index i, check whether there is any index j
 *   containing the key within distance k.
 * - If such an index exists, add i to the result.
 * - Since we check indices from left to right, the result
 *   is automatically sorted.
 *
 * Approach:
 * - Create a List to store the valid indices.
 * - For every index i:
 *   - Check every index j in the array.
 *   - If nums[j] is equal to key and the distance between
 *     i and j is at most k, add i to the result.
 *   - Break the inner loop because i is already confirmed.
 * - Return the result.
 *
 * Example:
 * nums = [3,4,9,1,3,9,5]
 * key = 9
 * k = 1
 *
 * Key indices are 2 and 5.
 *
 * Valid indices:
 * 1, 2, 3 → within distance 1 of index 2
 * 4, 5, 6 → within distance 1 of index 5
 *
 * Answer = [1,2,3,4,5,6]
 *
 * Time Complexity: O(n²)
 * - For every index i, we may check all n indices j.
 *
 * Space Complexity: O(n)
 * - The result list can contain up to n indices.
 */
public class FindAllKDistantIndicesInAnArray {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                // Check if nums[j] is the key and
                // index j is within distance k from i.
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FindAllKDistantIndicesInAnArray obj =
                new FindAllKDistantIndicesInAnArray();

        // Example 1
        int[] nums1 = {3, 4, 9, 1, 3, 9, 5};
        int key1 = 9;
        int k1 = 1;

        List<Integer> result1 =
                obj.findKDistantIndices(nums1, key1, k1);

        System.out.println("Output 1: " + result1);

        // Example 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int key2 = 2;
        int k2 = 2;

        List<Integer> result2 =
                obj.findKDistantIndices(nums2, key2, k2);

        System.out.println("Output 2: " + result2);
    }
}