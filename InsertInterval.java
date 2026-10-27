
import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Insert Interval
 * Difficulty: Medium
 *
 * Approach:
 * Process the intervals in three phases:
 * 1. Add intervals that come before the new interval.
 * 2. Merge all overlapping intervals.
 * 3. Add intervals that come after the merged interval.
 *
 * The input intervals are already sorted by starting value,
 * so sorting is not required.
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        // Store the final intervals in this list.
        List<int[]> result = new ArrayList<>();

        // Index used to traverse the existing intervals.
        int i = 0;

        // Total number of existing intervals.
        int n = intervals.length;

        // Copy the new interval's boundaries into local variables
        // so that the original newInterval array is not modified.
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // PHASE 1:
        // Add intervals that end before the new interval starts.
        //
        // If intervals[i][1] < newStart, the intervals do not
        // overlap, and this interval belongs before the new one.
        while (i < n && intervals[i][1] < newStart) {

            result.add(intervals[i]);
            i++;
        }

        // PHASE 2:
        // Merge every interval that overlaps the new interval.
        //
        // An interval overlaps when its start is less than
        // or equal to the current merged interval's end.
        while (i < n && intervals[i][0] <= newEnd) {

            // Extend the merged interval to the left if needed.
            if (intervals[i][0] < newStart) {
                newStart = intervals[i][0];
            }

            // Extend the merged interval to the right if needed.
            if (intervals[i][1] > newEnd) {
                newEnd = intervals[i][1];
            }

            // Move to the next interval.
            i++;
        }

        // Add the final merged interval exactly once.
        result.add(new int[]{newStart, newEnd});

        // PHASE 3:
        // All remaining intervals come after the merged interval.
        // They do not need any additional processing.
        while (i < n) {

            result.add(intervals[i]);
            i++;
        }

        // Convert the list into the required two-dimensional array.
        return result.toArray(new int[result.size()][]);
    }

    // Helper method to print a two-dimensional interval array.
    private static void printIntervals(int[][] intervals) {

        System.out.print("[");

        for (int i = 0; i < intervals.length; i++) {

            System.out.print(
                "[" + intervals[i][0] + ", " + intervals[i][1] + "]"
            );

            if (i < intervals.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    // Main method for testing.
    public static void main(String[] args) {

        InsertInterval solution = new InsertInterval();

        // Test Case 1: New interval overlaps the first interval.
        int[][] intervals1 = {
            {1, 3},
            {6, 9}
        };
        int[] newInterval1 = {2, 5};

        System.out.println("Test Case 1:");
        printIntervals(solution.insert(intervals1, newInterval1));
        // Expected: [[1, 5], [6, 9]]

        // Test Case 2: New interval overlaps multiple intervals.
        int[][] intervals2 = {
            {1, 2},
            {3, 5},
            {6, 7},
            {8, 10},
            {12, 16}
        };
        int[] newInterval2 = {4, 8};

        System.out.println("\nTest Case 2:");
        printIntervals(solution.insert(intervals2, newInterval2));
        // Expected: [[1, 2], [3, 10], [12, 16]]

        // Test Case 3: No existing intervals.
        int[][] intervals3 = {};
        int[] newInterval3 = {5, 7};

        System.out.println("\nTest Case 3:");
        printIntervals(solution.insert(intervals3, newInterval3));
        // Expected: [[5, 7]]

        // Test Case 4: New interval comes after all intervals.
        int[][] intervals4 = {
            {1, 2},
            {4, 5}
        };
        int[] newInterval4 = {7, 9};

        System.out.println("\nTest Case 4:");
        printIntervals(solution.insert(intervals4, newInterval4));
        // Expected: [[1, 2], [4, 5], [7, 9]]

        // Test Case 5: New interval connects at an endpoint.
        int[][] intervals5 = {
            {1, 3},
            {6, 9}
        };
        int[] newInterval5 = {3, 6};

        System.out.println("\nTest Case 5:");
        printIntervals(solution.insert(intervals5, newInterval5));
        // Expected: [[1, 9]]

        // Test Case 6: New interval contains existing intervals.
        int[][] intervals6 = {
            {2, 3},
            {5, 7}
        };
        int[] newInterval6 = {1, 8};

        System.out.println("\nTest Case 6:");
        printIntervals(solution.insert(intervals6, newInterval6));
        // Expected: [[1, 8]]
    }
}
