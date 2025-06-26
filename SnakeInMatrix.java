/**
 * Problem: Snake in Matrix
 * Difficulty: Easy
 *
 * A snake starts at position 0 in an n x n grid.
 * Each command moves the snake in one of four directions.
 * The task is to return the final cell number the snake ends up in.
 * Formula: position = row * n + col
 */

import java.util.*;

public class SnakeInMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0, col = 0;

        for (String command : commands) {
            switch (command) {
                case "UP":    row--; break;
                case "DOWN":  row++; break;
                case "LEFT":  col--; break;
                case "RIGHT": col++; break;
            }
        }

        return (row * n) + col;
    }

    public static void main(String[] args) {
        SnakeInMatrix solution = new SnakeInMatrix();

        int n1 = 2;
        List<String> commands1 = Arrays.asList("RIGHT", "DOWN");
        System.out.println(solution.finalPositionOfSnake(n1, commands1)); // Output: 3

        int n2 = 3;
        List<String> commands2 = Arrays.asList("DOWN", "RIGHT", "UP");
        System.out.println(solution.finalPositionOfSnake(n2, commands2)); // Output: 1
    }
}
