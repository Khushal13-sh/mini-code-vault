/*
 add solution for toggle light bulbs using set based frequency tracking
*/

/**
 * Problem: Toggle Light Bulbs
 * Difficulty: Easy
 *
 * Description:
 * Given a list of bulb indices, toggle their state (on/off).
 * Initially, all bulbs are off.
 * Return the bulbs that are on at the end in sorted order.
 *
 * Approach:
 * - Use a HashSet to track bulbs that are currently ON
 * - If bulb exists → remove it (turn OFF)
 * - Else → add it (turn ON)
 * - Convert set to list and sort
 *
 * Why this works:
 * Set maintains unique elements and helps simulate toggling efficiently.
 *
 * Time Complexity: O(n log n) (due to sorting)
 * Space Complexity: O(n)
 */
import java.util.*;

public class ToggleLightBulbs {

    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {

        Set<Integer> set = new HashSet<>();

        for (int bulb : bulbs) {
            if (set.contains(bulb)) {
                set.remove(bulb);
            } else {
                set.add(bulb);
            }
        }

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        ToggleLightBulbs obj = new ToggleLightBulbs();

        // Example 1
        List<Integer> bulbs1 = Arrays.asList(10, 30, 20, 10);
        System.out.println("Output 1: " + obj.toggleLightBulbs(bulbs1)); // [20, 30]

        // Example 2
        List<Integer> bulbs2 = Arrays.asList(100, 100);
        System.out.println("Output 2: " + obj.toggleLightBulbs(bulbs2)); // []
    }
}