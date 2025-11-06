/**
 * Problem: Zigzag Grid Traversal With Skip
 * Difficulty: Easy
 *
 * Description:
 * You are given an m x n grid of positive integers.
 * Traverse it in a zigzag pattern, skipping every alternate cell.
 *
 * Zigzag traversal means:
 * - Start at top-left (0,0)
 * - Move right across the first row
 * - Drop down to the next row and move left
 * - Alternate directions for each row
 * 
 * Important: Skip every alternate cell globally across the traversal.
 *
 * Example 1:
 * Input: grid = [[1,2],[3,4]]
 * Output: [1,4]
 *
 * Example 2:
 * Input: grid = [[2,1],[2,1],[2,1]]
 * Output: [2,1,2]
 *
 * Example 3:
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,3,5,7,9]
 */

import java.util.*;

public class ZigzagGridTraversalWithSkip {

    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        boolean skip = false;

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) { // left to right
                for (int j = 0; j < n; j++) {
                    if (!skip) result.add(grid[i][j]);
                    skip = !skip;
                }
            } else { // right to left
                for (int j = n - 1; j >= 0; j--) {
                    if (!skip) result.add(grid[i][j]);
                    skip = !skip;
                }
            }
        }

        return result;
    }

    // --- main method for quick testing ---
    public static void main(String[] args) {
        ZigzagGridTraversalWithSkip obj = new ZigzagGridTraversalWithSkip();

        System.out.println(obj.zigzagTraversal(new int[][]{{1,2},{3,4}})); // [1,4]
        System.out.println(obj.zigzagTraversal(new int[][]{{2,1},{2,1},{2,1}})); // [2,1,2]
        System.out.println(obj.zigzagTraversal(new int[][]{{1,2,3},{4,5,6},{7,8,9}})); // [1,3,5,7,9]
    }
}
