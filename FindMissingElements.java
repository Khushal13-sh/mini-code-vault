import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Find Missing Elements in a Range
 * Difficulty: Easy
 *
 * Steps:
 * - Identify min and max values from array.
 * - Check each value in range if it exists in input array.
 * - Store missing ones and return the list.
 */

public class FindMissingElements {

    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        // Step 1: Find minimum and maximum values
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Check missing numbers in range
        for (int num = min; num <= max; num++) {
            boolean found = false;
            for (int arrValue : nums) {
                if (arrValue == num) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindMissingElements solution = new FindMissingElements();

        System.out.println(solution.findMissingElements(new int[]{1,4,2,5})); // Output: [3]
        System.out.println(solution.findMissingElements(new int[]{7,8,6,9})); // Output: []
        System.out.println(solution.findMissingElements(new int[]{5,1}));     // Output: [2,3,4]
    }
}
