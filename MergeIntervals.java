import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge Intervals
 *
 * Problem:
 * Given an array of intervals where intervals[i] = [start, end],
 * merge all overlapping intervals and return an array of
 * non-overlapping intervals that covers all the input intervals.
 *
 * Example:
 *
 * Input:
 * [[1,3], [2,6], [8,10], [15,18]]
 *
 * Output:
 * [[1,6], [8,10], [15,18]]
 *
 * Explanation:
 * [1,3] and [2,6] overlap, so they are merged into [1,6].
 *
 * Approach:
 * 1. Sort all intervals by their starting value.
 * 2. Keep track of the current interval using start and end.
 * 3. If the next interval starts before or at the current end,
 *    the intervals overlap, so extend the current end.
 * 4. If there is no overlap, add the current interval to the result
 *    and start processing the next interval.
 *
 * Time Complexity:
 * O(n log n)
 *
 * Sorting takes O(n log n), and traversing the intervals takes O(n).
 *
 * Space Complexity:
 * O(n)
 *
 * The result list can contain up to n intervals.
 */
public class MergeIntervals {

    /**
     * Merges all overlapping intervals.
     *
     * @param intervals array containing intervals
     * @return merged non-overlapping intervals
     */
    public static int[][] merge(int[][] intervals) {

        // Sort intervals based on their starting value.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Start with the first interval.
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Check all remaining intervals.
        for (int i = 1; i < intervals.length; i++) {

            // Current interval overlaps with the next interval.
            if (intervals[i][0] <= end) {

                // Extend the end if required.
                end = Math.max(end, intervals[i][1]);

            } else {

                // No overlap, so store the current interval.
                result.add(new int[]{start, end});

                // Start a new interval.
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the final interval.
        result.add(new int[]{start, end});

        // Convert List<int[]> into int[][].
        return result.toArray(new int[result.size()][]);
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        // Example 1
        int[][] intervals1 = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println("Example 1:");
        System.out.println("Input: [[1,3],[2,6],[8,10],[15,18]]");

        int[][] result1 = merge(intervals1);

        System.out.println("Output: " + Arrays.deepToString(result1));

        System.out.println();

        // Example 2
        int[][] intervals2 = {
                {1, 4},
                {4, 5}
        };

        System.out.println("Example 2:");
        System.out.println("Input: [[1,4],[4,5]]");

        int[][] result2 = merge(intervals2);

        System.out.println("Output: " + Arrays.deepToString(result2));

        System.out.println();

        // Example 3
        int[][] intervals3 = {
                {4, 7},
                {1, 4}
        };

        System.out.println("Example 3:");
        System.out.println("Input: [[4,7],[1,4]]");

        int[][] result3 = merge(intervals3);

        System.out.println("Output: " + Arrays.deepToString(result3));
    }
}