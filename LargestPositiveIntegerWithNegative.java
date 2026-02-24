import java.util.HashSet;
import java.util.Set;

/**
 * ------------------------------------------------------------
 * Class Name : LargestPositiveIntegerWithNegative
 *
 * Description :
 * Finds the largest positive integer k such that
 * both k and -k exist in the array.
 *
 * ------------------------------------------------------------
 */
public class LargestPositiveIntegerWithNegative {

    /**
     * Returns the largest valid k, or -1 if none exists.
     */
    public int findMaxK(int[] nums) {

        Set<Integer> set = new HashSet<>();

        // Store all numbers in a set
        for (int num : nums) {
            set.add(num);
        }

        int max = -1;

        // Check for positive numbers whose negative exists
        for (int num : nums) {
            if (num > 0 && set.contains(-num)) {
                max = Math.max(max, num);
            }
        }

        return max;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        LargestPositiveIntegerWithNegative solution =
                new LargestPositiveIntegerWithNegative();

        System.out.println(solution.findMaxK(new int[]{-1,2,-3,3}));       // 3
        System.out.println(solution.findMaxK(new int[]{-1,10,6,7,-7,1}));  // 7
        System.out.println(solution.findMaxK(new int[]{-10,8,6,7,-2,-3})); // -1
    }
}