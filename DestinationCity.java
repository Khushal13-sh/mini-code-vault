/**
 * Problem Title: Destination City
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * You are given the array 'paths', where paths[i] = [cityA, cityB] means 
 * there exists a direct path going from cityA to cityB. 
 * 
 * You need to return the **destination city**, which is the city that 
 * does not have any outgoing path to another city.
 * 
 * 📥 Example 1:
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation:
 * - The path is: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 * - The destination city is "Sao Paulo" because it has no outgoing path.
 * 
 * 📥 Example 2:
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation:
 * - The path is: "D" -> "B" -> "C" -> "A".
 * - The destination city is "A".
 * 
 * 📥 Example 3:
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 * Explanation:
 * - The path is: "A" -> "Z".
 * - The destination city is "Z".
 * 
 * 📌 Constraints:
 * - 1 <= paths.length <= 100
 * - paths[i].length == 2
 * - 1 <= cityA.length, cityB.length <= 10
 * - cityA != cityB
 * - All strings consist of lowercase and uppercase English letters and spaces.
 */

import java.util.*;

public class DestinationCity {

    /**
     * 🧠 Logic:
     * - Use a HashSet to store all starting cities from the given paths.
     * - Iterate through each destination city.
     * - If a city is not present in the set of starting cities, it is the destination.
     * - Return that city.
     */
    public static String destCity(List<List<String>> paths) {
        Set<String> startCities = new HashSet<>();

        // Add all starting cities to the set
        for (List<String> path : paths) {
            startCities.add(path.get(0));
        }

        // Check for the city that is not a starting city
        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!startCities.contains(destination)) {
                return destination;
            }
        }

        return ""; // Fallback (won't reach here as per problem guarantee)
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        List<List<String>> paths1 = Arrays.asList(
            Arrays.asList("London", "New York"),
            Arrays.asList("New York", "Lima"),
            Arrays.asList("Lima", "Sao Paulo")
        );
        System.out.println("Destination City: " + destCity(paths1));  // Expected: "Sao Paulo"

        List<List<String>> paths2 = Arrays.asList(
            Arrays.asList("B", "C"),
            Arrays.asList("D", "B"),
            Arrays.asList("C", "A")
        );
        System.out.println("Destination City: " + destCity(paths2));  // Expected: "A"

        List<List<String>> paths3 = Arrays.asList(
            Arrays.asList("A", "Z")
        );
        System.out.println("Destination City: " + destCity(paths3));  // Expected: "Z"
    }
}
