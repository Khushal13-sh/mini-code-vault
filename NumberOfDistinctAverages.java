/**
 * ------------------------------------------------------------
 * Class Name : NumberOfDistinctAverages
 *
 * Description :
 * Repeatedly removes the minimum and maximum numbers
 * from the array, calculates their average, and returns
 * the count of distinct averages formed.
 *
 * ------------------------------------------------------------
 */
import java.util.Arrays;
import java.util.HashSet;

public class NumberOfDistinctAverages {

    /**
     * Returns the number of distinct averages.
     */
    public int distinctAverages(int[] nums) {

        // Sort the array to easily access min and max
        Arrays.sort(nums);

        HashSet<Double> averages = new HashSet<>();

        int left = 0;
        int right = nums.length - 1;

        // Process until all pairs are removed
        while (left < right) {
            double avg = (nums[left] + nums[right]) / 2.0;
            averages.add(avg);
            left++;
            right--;
        }

        return averages.size();
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        NumberOfDistinctAverages solution = new NumberOfDistinctAverages();

        System.out.println(solution.distinctAverages(new int[]{4,1,4,0,3,5})); // 2
        System.out.println(solution.distinctAverages(new int[]{1,100}));        // 1
    }
}
