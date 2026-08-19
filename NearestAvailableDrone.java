/*
 add solution for nearest available drone
*/

/**
 * Problem: Nearest Available Drone
 * Difficulty: Easy
 *
 * Description:
 * Given a 2D integer array drones, where each drone contains
 * its x-coordinate, y-coordinate, and travel range, determine
 * the reachable drone that is closest to the target using
 * Manhattan distance.
 *
 * A drone can reach the target if its Manhattan distance from
 * the target is less than or equal to its travel range.
 *
 * If multiple reachable drones have the same minimum distance,
 * return the drone with the smallest index.
 *
 * If no drone can reach the target, return -1.
 *
 * Key Insight:
 * - Calculate the Manhattan distance for every drone.
 * - A drone is reachable only when:
 *
 *   distance <= range
 *
 * - Among all reachable drones, keep the one with the
 *   smallest distance.
 * - Since we traverse the drones from left to right and only
 *   update when the distance is strictly smaller, a tie
 *   automatically keeps the smaller index.
 *
 * Approach:
 * - Initialize answer as -1.
 * - Initialize minDistance as Integer.MAX_VALUE.
 * - Traverse every drone.
 * - Calculate its Manhattan distance from the target.
 * - Check whether the drone can reach the target.
 * - If it can reach and its distance is smaller than the
 *   current minimum, update the answer and minimum distance.
 * - Return the answer after checking all drones.
 *
 * Why this works:
 * Every drone is checked exactly once.
 * We only consider drones whose distance is within their range.
 *
 * When a drone has a smaller distance, we update the answer.
 * When two drones have the same distance, we do not update
 * the answer, so the first drone remains selected.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
public class NearestAvailableDrone {

    public int nearestDrone(int[][] drones, int[] target) {

        int answer = -1;
        int minDistance = Integer.MAX_VALUE;

        // Check every drone.
        for (int i = 0; i < drones.length; i++) {

            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];

            // Calculate Manhattan distance.
            int distance =
                    Math.abs(x - target[0]) +
                    Math.abs(y - target[1]);

            // Check if the drone can reach the target
            // and is closer than the current best drone.
            if (distance <= range && distance < minDistance) {
                minDistance = distance;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        NearestAvailableDrone obj =
                new NearestAvailableDrone();

        // Example 1
        int[][] drones1 = {
                {0, 0, 8},
                {2, 2, 9}
        };

        int[] target1 = {3, 4};

        int result1 = obj.nearestDrone(drones1, target1);

        System.out.println("Output 1: " + result1);

        // Example 2
        int[][] drones2 = {
                {2, 1, 5},
                {4, 4, 5},
                {6, 6, 8}
        };

        int[] target2 = {5, 5};

        int result2 = obj.nearestDrone(drones2, target2);

        System.out.println("Output 2: " + result2);

        // Example 3
        int[][] drones3 = {
                {4, 4, 5}
        };

        int[] target3 = {8, 6};

        int result3 = obj.nearestDrone(drones3, target3);

        System.out.println("Output 3: " + result3);
    }
}