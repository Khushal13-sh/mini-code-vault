/**
 * Problem: Find Nearest Point That Has the Same X or Y Coordinate
 * Difficulty: Easy
 *
 * You are at location (x, y) on a Cartesian grid.
 * You are given an array points where each points[i] = [ai, bi] is a point on the grid.
 *
 * A point is valid if it shares the same x-coordinate or y-coordinate as your location.
 * Return the index of the valid point with the smallest Manhattan distance.
 * If multiple valid points have the same distance, return the one with the smallest index.
 * If no valid points exist, return -1.
 *
 * Manhattan distance between (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).
 *
 * Example 1:
 * Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * Output: 2
 *
 * Example 2:
 * Input: x = 3, y = 4, points = [[3,4]]
 * Output: 0
 *
 * Example 3:
 * Input: x = 3, y = 4, points = [[2,3]]
 * Output: -1
 *
 * Constraints:
 * - 1 <= points.length <= 10^4
 * - points[i].length == 2
 * - 1 <= x, y, ai, bi <= 10^4
 */
public class NearestValidPoint {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE;
        int resultIndex = -1;

        for (int i = 0; i < points.length; i++) {
            int px = points[i][0];
            int py = points[i][1];

            if (px == x || py == y) {
                int distance = Math.abs(px - x) + Math.abs(py - y);
                if (distance < minDistance) {
                    minDistance = distance;
                    resultIndex = i;
                }
            }
        }

        return resultIndex;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        NearestValidPoint solution = new NearestValidPoint();

        int[][] points1 = {{1,2},{3,1},{2,4},{2,3},{4,4}};
        System.out.println(solution.nearestValidPoint(3,4, points1)); // 2

        int[][] points2 = {{3,4}};
        System.out.println(solution.nearestValidPoint(3,4, points2)); // 0

        int[][] points3 = {{2,3}};
        System.out.println(solution.nearestValidPoint(3,4, points3)); // -1
    }
}
