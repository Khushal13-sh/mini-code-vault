import java.util.*;

/**
 * Problem: Two Furthest Houses With Different Colors
 * Difficulty: Easy
 *
 * Find the maximum distance between two houses
 * that have different colors.
 */

public class TwoFurthestHousesWithDifferentColors {

    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDistance = 0;

        // Compare with first house color
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                maxDistance = i;
                break;
            }
        }

        // Compare with last house color
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDistance = Math.max(maxDistance, n - 1 - i);
                break;
            }
        }

        return maxDistance;
    }

    // Main method for testing
    public static void main(String[] args) {
        TwoFurthestHousesWithDifferentColors obj =
                new TwoFurthestHousesWithDifferentColors();

        System.out.println(obj.maxDistance(new int[]{1,1,1,6,1,1,1})); // 3
        System.out.println(obj.maxDistance(new int[]{1,8,3,8,3}));     // 4
        System.out.println(obj.maxDistance(new int[]{0,1}));           // 1
    }
}
