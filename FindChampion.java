/**
 * Problem: Find Champion I
 * Difficulty: Easy
 *
 * Given a 2D boolean matrix grid of size n x n where grid[i][j] == 1
 * means team i is stronger than team j, return the champion team.
 * A champion is the one for whom no other team is stronger.
 */

public class FindChampion {

    public int findChampion(int[][] grid) {
        int n = grid.length;

        // Loop through each team as a potential champion
        for (int col = 0; col < n; col++) {
            boolean isChampion = true;

            // Check if any team is stronger than the current team
            for (int row = 0; row < n; row++) {
                if (row != col && grid[row][col] == 1) {
                    isChampion = false;
                    break;
                }
            }

            // If no team is stronger, this is the champion
            if (isChampion) {
                return col;
            }
        }

        return -1; // Should not reach here as per problem constraints
    }

    public static void main(String[] args) {
        FindChampion solution = new FindChampion();

        int[][] test1 = {
            {0, 1},
            {0, 0}
        };
        System.out.println(solution.findChampion(test1)); // Output: 0

        int[][] test2 = {
            {0, 0, 1},
            {1, 0, 1},
            {0, 0, 0}
        };
        System.out.println(solution.findChampion(test2)); // Output: 1
    }
}
