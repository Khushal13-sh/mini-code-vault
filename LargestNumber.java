/**
 * Largest Number
 *
 * Problem:
 * Given a list of non-negative integers, arrange them in such a way
 * that they form the largest possible number.
 *
 * Since the result can be very large, return the result as a String.
 *
 * Example:
 *
 * Input:
 * [3, 30, 34, 5, 9]
 *
 * Output:
 * "9534330"
 *
 * Approach:
 * Convert all integers into Strings.
 *
 * For every two numbers a and b, compare:
 *
 *     a + b
 *     b + a
 *
 * If a + b is smaller than b + a, then b should come before a.
 *
 * Example:
 *
 *     a = "3"
 *     b = "30"
 *
 *     "3" + "30" = "330"
 *     "30" + "3" = "303"
 *
 * Since "330" is larger, 3 should come before 30.
 *
 * After arranging all numbers, concatenate them to form the answer.
 *
 * Special Case:
 * If the largest number is "0", then all numbers are zero.
 * In that case, return "0" instead of something like "0000".
 *
 * Time Complexity:
 * O(n^2 * k)
 *
 * where n is the number of elements and k is the average length
 * of the numbers.
 *
 * Space Complexity:
 * O(n)
 * for the String array.
 */
public class LargestNumber {

    /**
     * Arranges the given numbers to form the largest possible number.
     *
     * @param nums array of non-negative integers
     * @return largest possible number as a String
     */
    public static String largestNumber(int[] nums) {

        // Convert all numbers to Strings.
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        /*
         * Sort the strings using the special comparison:
         *
         * Compare a + b with b + a.
         *
         * The combination which produces the larger value
         * should come first.
         */
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                String first = arr[i] + arr[j];
                String second = arr[j] + arr[i];

                // If second combination is larger, swap them.
                if (first.compareTo(second) < 0) {

                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        /*
         * If the first element is "0", all elements are zero.
         * Return only one zero.
         */
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the final largest number.
        StringBuilder result = new StringBuilder();

        for (String num : arr) {
            result.append(num);
        }

        return result.toString();
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {10, 2};

        System.out.println("Example 1:");
        System.out.println("Input: [10, 2]");
        System.out.println("Output: " + largestNumber(nums1));

        System.out.println();

        // Example 2
        int[] nums2 = {3, 30, 34, 5, 9};

        System.out.println("Example 2:");
        System.out.println("Input: [3, 30, 34, 5, 9]");
        System.out.println("Output: " + largestNumber(nums2));

        System.out.println();

        // Example 3 - all zeros
        int[] nums3 = {0, 0, 0};

        System.out.println("Example 3:");
        System.out.println("Input: [0, 0, 0]");
        System.out.println("Output: " + largestNumber(nums3));

        System.out.println();

        // Example 4
        int[] nums4 = {9, 91, 90, 8};

        System.out.println("Example 4:");
        System.out.println("Input: [9, 91, 90, 8]");
        System.out.println("Output: " + largestNumber(nums4));
    }
}