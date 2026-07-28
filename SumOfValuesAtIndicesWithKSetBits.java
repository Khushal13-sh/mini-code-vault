/*
 add solution for summing values at indices with k set bits
*/

/**
 * Problem: Sum of Values at Indices With K Set Bits
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums and an integer k,
 * calculate the sum of elements whose corresponding
 * index contains exactly k set bits in its binary form.
 *
 * Key Insight:
 * - Use Integer.bitCount(index) to count the number
 *   of set bits in the binary representation of the index.
 * - If the count equals k, add the corresponding
 *   element to the sum.
 *
 * Approach:
 * - Traverse every index of the array.
 * - Count the set bits of the current index.
 * - If the number of set bits equals k, add nums[index].
 * - Return the final sum.
 *
 * Why this works:
 * Integer.bitCount(index) directly gives the number
 * of 1s in the binary representation of the index,
 * so we only add values from indices that satisfy
 * the required condition.
 *
 * Time Complexity: O(n)
 * Each index is visited once.
 *
 * Space Complexity: O(1)
 * Only the sum variable is used.
 */
public class SumOfValuesAtIndicesWithKSetBits {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {

            if (Integer.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        SumOfValuesAtIndicesWithKSetBits obj =
                new SumOfValuesAtIndicesWithKSetBits();

        // Example 1
        List<Integer> nums1 = Arrays.asList(5, 10, 1, 5, 2);
        System.out.println("Output 1: " +
                obj.sumIndicesWithKSetBits(nums1, 1));

        // Example 2
        List<Integer> nums2 = Arrays.asList(4, 3, 2, 1);
        System.out.println("Output 2: " +
                obj.sumIndicesWithKSetBits(nums2, 2));
    }
}