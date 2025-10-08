/**
 * Problem: Earliest Time to Finish One Task
 * Difficulty: Easy
 *
 * Description:
 * You are given a 2D integer array tasks where tasks[i] = [si, ti].
 * Each [si, ti] represents a task that starts at time si and takes ti units of time.
 * Return the earliest time when at least one task finishes.
 *
 * Example:
 * Input: tasks = [[1,6],[2,3]]
 * Output: 5
 *
 * Approach:
 * - For each task, calculate its finish time = start + duration.
 * - Track the minimum finish time among all tasks.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class EarliestTimeToFinishOneTask {

    public int earliestTime(int[][] tasks) {
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < tasks.length; i++) {
            int start = tasks[i][0];
            int duration = tasks[i][1];
            int finish = start + duration;
            minTime = Math.min(minTime, finish);
        }

        return minTime;
    }

    // main method for testing examples
    public static void main(String[] args) {
        EarliestTimeToFinishOneTask solution = new EarliestTimeToFinishOneTask();

        // Example 1
        int[][] tasks1 = {{1, 6}, {2, 3}};
        System.out.println("Example 1 Output: " + solution.earliestTime(tasks1));
        // Expected: 5

        // Example 2
        int[][] tasks2 = {{100, 100}, {100, 100}, {100, 100}};
        System.out.println("Example 2 Output: " + solution.earliestTime(tasks2));
        // Expected: 200
    }
}
