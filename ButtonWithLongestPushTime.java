/**
 * Problem: Button with Longest Push Time
 * Difficulty: Easy
 *
 * Description:
 * You are given a 2D array events, where each events[i] = [index, time]
 * indicates that a button with index was pressed at time.
 *
 * - The time for the first button = its pressed time.
 * - For other buttons, the time = difference between consecutive press times.
 * - Return the index of the button with the longest press time.
 * - If multiple buttons have the same longest press time, return the one with smallest index.
 *
 * Example 1:
 * Input: events = [[1,2],[2,5],[3,9],[1,15]]
 * Output: 1
 *
 * Example 2:
 * Input: events = [[10,5],[1,7]]
 * Output: 10
 *
 * Constraints:
 * 1 <= events.length <= 1000
 * 1 <= index, time <= 100000
 * events is sorted in increasing order of time.
 *
 * Approach:
 * - Track press duration for each event.
 * - For i > 0, duration = time[i] - time[i-1].
 * - Keep max duration and corresponding index.
 * - Resolve ties by choosing smaller index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ButtonWithLongestPushTime {

    /**
     * Returns the button index with the longest press time.
     *
     * @param events 2D array of events [index, time]
     * @return button index with longest press
     */
    public int buttonWithLongestTime(int[][] events) {
        int n = events.length;

        // First button press duration
        int maxTime = events[0][1];
        int answer = events[0][0];

        // Calculate durations for the rest
        for (int i = 1; i < n; i++) {
            int duration = events[i][1] - events[i - 1][1];
            int index = events[i][0];

            if (duration > maxTime) {
                maxTime = duration;
                answer = index;
            } else if (duration == maxTime && index < answer) {
                answer = index;
            }
        }
        return answer;
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        ButtonWithLongestPushTime solution = new ButtonWithLongestPushTime();

        int[][] events1 = {{1,2},{2,5},{3,9},{1,15}};
        System.out.println("Output: " + solution.buttonWithLongestTime(events1)); // Expected 1

        int[][] events2 = {{10,5},{1,7}};
        System.out.println("Output: " + solution.buttonWithLongestTime(events2)); // Expected 10

        int[][] events3 = {{2,3},{5,8},{4,12},{1,17}};
        System.out.println("Output: " + solution.buttonWithLongestTime(events3)); // Custom test
    }
}
