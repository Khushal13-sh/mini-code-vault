/**
 * Problem: Maximum Count of Positive Integer and Negative Integer
 * Difficulty: Easy
 *
 * Return the maximum between the count of positive
 * and negative integers in a sorted array.
 * Note: 0 is neither positive nor negative.
 */
public class MaximumCountPositiveNegative {

    public int maximumCount(int[] nums) {

        int neg = 0;
        int pos = 0;

        // Traverse array and count positives and negatives
        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num > 0) {
                pos++;
            }
        }

        // Return the maximum count
        return neg > pos ? neg : pos;
    }

    // Main method for testing
    public static void main(String[] args) {
        MaximumCountPositiveNegative obj = new MaximumCountPositiveNegative();

        System.out.println(obj.maximumCount(
                new int[]{-2, -1, -1, 1, 2, 3})); // 3

        System.out.println(obj.maximumCount(
                new int[]{-3, -2, -1, 0, 0, 1, 2})); // 3

        System.out.println(obj.maximumCount(
                new int[]{5, 20, 66, 1314})); // 4
    }
}
