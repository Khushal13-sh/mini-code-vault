import java.util.*;

/**
 * Problem: Minimum Amount of Time to Fill Cups
 * Difficulty: Easy
 *
 * You can fill up to 2 cups per second, each with a different water type.
 * Return the minimum number of seconds to fill all cups given in the array.
 */

public class FillCups {

    public int fillCups(int[] amount) {
        int total = amount[0] + amount[1] + amount[2];

        int max = Math.max(amount[0], Math.max(amount[1], amount[2]));

        // Minimum seconds = max of (most needed cup) and (ceil of total / 2)
        return Math.max(max, (total + 1) / 2);
    }

    public static void main(String[] args) {
        FillCups solution = new FillCups();

        int[] test1 = {1, 4, 2};
        System.out.println("Output: " + solution.fillCups(test1)); // Output: 4

        int[] test2 = {5, 4, 4};
        System.out.println("Output: " + solution.fillCups(test2)); // Output: 7

        int[] test3 = {5, 0, 0};
        System.out.println("Output: " + solution.fillCups(test3)); // Output: 5
    }
}

