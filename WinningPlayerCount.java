/**
 * Problem: Find the Number of Winning Players
 * Difficulty: Easy
 *
 * You are given an integer n and a 2D array `pick`, where pick[i] = [xi, yi]
 * represents that player xi picked a ball of color yi.
 *
 * A player i wins if they pick strictly more than i balls of the same color.
 * That means player 0 wins if they have 1 ball of any color,
 * player 1 wins if they have 2 of the same color, and so on.
 *
 * Approach:
 * 1. Track how many balls of each color each player has using a 2D array.
 * 2. For each player, check if they have any color with count >= (i + 1).
 * 3. Count how many such players exist and return the count.
 */

import java.util.*;

public class WinningPlayerCount {

    public int winningPlayerCount(int n, int[][] pick) {
        // Find the maximum color value to define the array bounds
        int maxColor = 0;
        for (int[] p : pick) {
            maxColor = Math.max(maxColor, p[1]);
        }

        // Create a count array for each player's color picks
        int[][] count = new int[n][maxColor + 1];

        for (int[] p : pick) {
            int player = p[0];
            int color = p[1];
            count[player][color]++;
        }

        int winningPlayers = 0;

        // Check for each player if they win based on color counts
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= maxColor; c++) {
                if (count[i][c] >= i + 1) {
                    winningPlayers++;
                    break; // No need to check more colors for this player
                }
            }
        }

        return winningPlayers;
    }

    public static void main(String[] args) {
        WinningPlayerCount solution = new WinningPlayerCount();

        int[][] pick1 = {{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}};
        int[][] pick2 = {{1, 1}, {1, 2}, {1, 3}, {1, 4}};
        int[][] pick3 = {{1, 1}, {2, 4}, {2, 4}, {2, 4}};
        int[][] pick4 = {{0, 5}, {1, 5}, {1, 5}, {2, 5}, {2, 5}, {2, 5}, {3, 5}, {3, 5}, {3, 5}, {3, 5}};

        System.out.println(solution.winningPlayerCount(4, pick1)); // Output: 2
        System.out.println(solution.winningPlayerCount(5, pick2)); // Output: 0
        System.out.println(solution.winningPlayerCount(5, pick3)); // Output: 1
        System.out.println(solution.winningPlayerCount(5, pick4)); // Output: 4
    }
}
