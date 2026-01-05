/**
 * Problem: Summary Ranges
 * Difficulty: Easy
 *
 * Convert a sorted unique integer array
 * into the smallest list of continuous ranges.
 */
import java.util.*;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {

            // End of array OR break in consecutive sequence
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {

                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }

                // Start new range
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();

        System.out.println(obj.summaryRanges(
                new int[]{0,1,2,4,5,7}));
        // ["0->2","4->5","7"]

        System.out.println(obj.summaryRanges(
                new int[]{0,2,3,4,6,8,9}));
        // ["0","2->4","6","8->9"]
    }
}
