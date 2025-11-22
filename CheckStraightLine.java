/**
 * Problem: Check If It Is a Straight Line
 * Difficulty: Easy
 *
 * Determine whether all given points lie on a single straight line
 * using slope checking through cross multiplication.
 */

public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {

        // First two points define the reference slope
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        int dx = x2 - x1;
        int dy = y2 - y1;

        // Verify slope consistency for all points
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            // Cross multiplication to avoid division
            if (dy * (x - x1) != dx * (y - y1)) {
                return false;
            }
        }

        return true;
    }

    // ------------ MAIN METHOD FOR TESTS ------------
    public static void main(String[] args) {
        CheckStraightLine sol = new CheckStraightLine();

        int[][] c1 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] c2 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        int[][] c3 = {{0,0},{1,1},{2,2},{3,3}};
        int[][] c4 = {{2,5},{2,7},{2,9}};

        System.out.println(sol.checkStraightLine(c1)); // true
        System.out.println(sol.checkStraightLine(c2)); // false
        System.out.println(sol.checkStraightLine(c3)); // true
        System.out.println(sol.checkStraightLine(c4)); // true (vertical line)
    }
}
