/*
 add solution for sorting integers by number of 1 bits using custom comparator
*/

/**
 * Problem: Sort Integers by The Number of 1 Bits
 * Difficulty: Easy
 *
 * Description:
 * Sort the array based on:
 * 1. Number of set bits (1's in binary representation)
 * 2. Numerical value if set bits are equal
 *
 * Key Insight:
 * - Java provides Integer.bitCount()
 * - Custom sorting can handle multiple conditions
 *
 * Approach:
 * - Convert int[] to Integer[]
 *   because Arrays.sort() with comparator
 *   works only with objects
 *
 * - Sort using custom comparator:
 *      - Compare bit counts first
 *      - If equal, compare actual values
 *
 * - Copy sorted values back to int[]
 *
 * Why this works:
 * Integer.bitCount() efficiently counts set bits.
 * Comparator ensures proper ordering according
 * to problem conditions.
 *
 * Time Complexity: O(n log n)
 *
 * Space Complexity: O(n)
 */
public class SortIntegersByBits {

    public int[] sortByBits(int[] arr) {

        Integer[] nums = new Integer[arr.length];

        // Convert primitive array to Integer array
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        // Custom sorting
        Arrays.sort(nums, (a, b) -> {

            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);

            // If same number of set bits
            // sort by actual value
            if (bitsA == bitsB) {
                return a - b;
            }

            // Sort by set bits
            return bitsA - bitsB;
        });

        // Copy back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }

    public static void main(String[] args) {

        SortIntegersByBits obj =
                new SortIntegersByBits();

        // Example 1
        int[] arr1 = {0,1,2,3,4,5,6,7,8};

        int[] result1 = obj.sortByBits(arr1);

        System.out.print("Output 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        // 0 1 2 4 8 3 5 6 7

        System.out.println();

        // Example 2
        int[] arr2 =
                {1024,512,256,128,64,32,16,8,4,2,1};

        int[] result2 = obj.sortByBits(arr2);

        System.out.print("Output 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        // 1 2 4 8 16 32 64 128 256 512 1024
    }
}