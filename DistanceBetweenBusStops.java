/**
 * Problem Title: Distance Between Bus Stops
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * A bus has n stops numbered from 0 to n - 1 that form a circle.
 * The distance array represents the distance between consecutive stops.
 * The bus can travel in both clockwise and counterclockwise directions.
 * 
 * 💡 Task:
 * Return the shortest distance between the given start and destination stops.
 * 
 * 📥 Example 1:
 * Input: distance = [1,2,3,4], start = 0, destination = 1
 * Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 * 
 * 📥 Example 2:
 * Input: distance = [1,2,3,4], start = 0, destination = 2
 * Output: 3
 * Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 * 
 * 📥 Example 3:
 * Input: distance = [1,2,3,4], start = 0, destination = 3
 * Output: 4
 * Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 * 
 * 📌 Constraints:
 * - 1 <= n <= 10^4
 * - distance.length == n
 * - 0 <= start, destination < n
 * - 0 <= distance[i] <= 10^4
 */

import java.util.*;

public class DistanceBetweenBusStops {

    /**
     * 🧠 Logic:
     * 1. Normalize start and destination to ensure start <= destination.
     * 2. Calculate clockwise distance by summing from start to destination.
     * 3. Calculate total distance by summing all distances.
     * 4. Counterclockwise distance = totalDistance - clockwiseDistance.
     * 5. Return the minimum of clockwise and counterclockwise distances.
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int clockwiseDistance = 0;
        for (int i = start; i < destination; i++) {
            clockwiseDistance += distance[i];
        }

        int totalDistance = Arrays.stream(distance).sum();
        int counterclockwiseDistance = totalDistance - clockwiseDistance;

        return Math.min(clockwiseDistance, counterclockwiseDistance);
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        DistanceBetweenBusStops solution = new DistanceBetweenBusStops();

        // Test case 1
        int[] distance1 = {1, 2, 3, 4};
        int start1 = 0, destination1 = 1;
        System.out.println("Test 1: " + solution.distanceBetweenBusStops(distance1, start1, destination1)); // Output: 1

        // Test case 2
        int[] distance2 = {1, 2, 3, 4};
        int start2 = 0, destination2 = 2;
        System.out.println("Test 2: " + solution.distanceBetweenBusStops(distance2, start2, destination2)); // Output: 3

        // Test case 3
        int[] distance3 = {1, 2, 3, 4};
        int start3 = 0, destination3 = 3;
        System.out.println("Test 3: " + solution.distanceBetweenBusStops(distance3, start3, destination3)); // Output: 4
    }
}
