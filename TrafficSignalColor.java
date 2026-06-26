/*
 add solution for determining traffic signal color based on timer
*/

/**
 * Problem: Traffic Signal Color
 * Difficulty: Easy
 *
 * Description:
 * Given an integer timer representing the remaining
 * time (in seconds) on a traffic signal:
 *
 * - If timer == 0, return "Green"
 * - If timer == 30, return "Orange"
 * - If 30 < timer <= 90, return "Red"
 * - Otherwise, return "Invalid"
 *
 * Return the current state of the traffic signal.
 *
 * Key Insight:
 * - Check the timer value against the given conditions
 *   in the specified order.
 *
 * Approach:
 * - If timer is 0, return "Green".
 * - Else if timer is 30, return "Orange".
 * - Else if timer is between 31 and 90 (inclusive),
 *   return "Red".
 * - Otherwise, return "Invalid".
 *
 * Why this works:
 * Each timer value belongs to only one valid condition,
 * so sequential conditional checks correctly determine
 * the signal state.
 *
 * Time Complexity: O(1)
 *
 * Space Complexity: O(1)
 * Only constant extra space is used.
 */
public class TrafficSignalColor {

    public String trafficSignal(int timer) {

        if (timer == 0) {
            return "Green";
        } else if (timer == 30) {
            return "Orange";
        } else if (timer > 30 && timer <= 90) {
            return "Red";
        } else {
            return "Invalid";
        }
    }

    public static void main(String[] args) {

        TrafficSignalColor obj = new TrafficSignalColor();

        // Example 1
        System.out.println("Output 1: " +
                obj.trafficSignal(60));

        // Example 2
        System.out.println("Output 2: " +
                obj.trafficSignal(5));

        // Example 3
        System.out.println("Output 3: " +
                obj.trafficSignal(0));

        // Example 4
        System.out.println("Output 4: " +
                obj.trafficSignal(30));
    }
}