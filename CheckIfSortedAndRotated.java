/**
 * Problem: Check if Array Is Sorted and Rotated
 * Difficulty: Easy
 *
 * An array is valid if it is a rotation of a non-decreasing sorted array.
 * We count the number of places where the current number is greater than the next.
 * If this happens more than once, it's not a valid rotation of a sorted array.
 */

public class CheckIfSortedAndRotated {

    public boolean check(int[] nums) {
        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // Use modulo to wrap around circularly
            if (nums[i] > nums[(i + 1) % len]) {
                count++;
            }
            if (count > 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfSortedAndRotated solution = new CheckIfSortedAndRotated();

        System.out.println(solution.check(new int[]{3, 4, 5, 1, 2})); // true
        System.out.println(solution.check(new int[]{2, 1, 3, 4}));    // false
        System.out.println(solution.check(new int[]{1, 2, 3}));       // true
        System.out.println(solution.check(new int[]{1, 1, 1}));       // true
        System.out.println(solution.check(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(solution.check(new int[]{5, 1, 2, 3, 4})); // true
    }
}
