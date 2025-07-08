/**
 * Problem: Find Greatest Common Divisor of Array
 * Difficulty: Easy
 *
 * Find the smallest and largest number in the array,
 * then return their greatest common divisor (GCD).
 */

public class FindGCDOfArray {

    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum elements
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(min, max);
    }

    // Euclidean algorithm to find GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        FindGCDOfArray solution = new FindGCDOfArray();

        System.out.println(solution.findGCD(new int[]{2, 5, 6, 9, 10})); // Output: 2
        System.out.println(solution.findGCD(new int[]{7, 5, 6, 8, 3}));  // Output: 1
        System.out.println(solution.findGCD(new int[]{3, 3}));           // Output: 3
    }
}
