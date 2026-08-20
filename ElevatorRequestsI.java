/*
 add solution for elevator requests i
*/

/**
 * Problem: Elevator Requests I
 * Difficulty: Easy
 *
 * Description:
 * Given a building with floors numbered from 0 to n - 1,
 * an elevator starts at floor 0 and serves floor requests
 * in the given order.
 *
 * The elevator moves one floor per second.
 * Return the total time required to serve all requests.
 *
 * Key Insight:
 * - The time required to move from one floor to another is
 *   the absolute difference between the two floor numbers.
 * - After serving each request, that floor becomes the
 *   elevator's current floor.
 *
 * Approach:
 * - Start the elevator at floor 0.
 * - Traverse every requested floor.
 * - Calculate the distance between the current floor and
 *   the requested floor.
 * - Add the distance to the total time.
 * - Update the current floor to the requested floor.
 * - Return the total time.
 *
 * Why this works:
 * The elevator serves requests in the exact given order,
 * so there is no need to choose or optimize the order.
 *
 * For every request:
 *
 *   Time = |currentFloor - requestedFloor|
 *
 * Adding these movements gives the total time.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
public class ElevatorRequestsI {

    public int elevatorRequests(int n, int[] requests) {

        int currentFloor = 0;
        int totalTime = 0;

        // Process each request in the given order.
        for (int floor : requests) {

            // Calculate the number of floors the elevator
            // needs to move.
            totalTime += Math.abs(currentFloor - floor);

            // The elevator is now at the requested floor.
            currentFloor = floor;
        }

        return totalTime;
    }

    public static void main(String[] args) {

        ElevatorRequestsI obj =
                new ElevatorRequestsI();

        // Example 1
        int[] requests1 = {2, 1, 4, 3};
        int result1 = obj.elevatorRequests(5, requests1);

        System.out.println("Output 1: " + result1);

        // Example 2
        int[] requests2 = {2, 0, 0};
        int result2 = obj.elevatorRequests(3, requests2);

        System.out.println("Output 2: " + result2);
    }
}