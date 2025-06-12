/**
 * Problem: Maximum Population Year
 * Difficulty: Easy
 *
 * 🔍 Description:
 * Given a list of birth and death years, find the year with the highest population.
 * Note: A person is counted in the year they are born, but NOT in the year they die.
 *
 * 🧪 Example:
 * Input: [[1950,1961],[1960,1971],[1970,1981]]
 * Output: 1960
 */

public class MaximumPopulationYear {

    public static int maximumPopulation(int[][] logs) {
        // Years from 1950 to 2050 → 101 years
        int[] yearChanges = new int[101];

        // Apply population change for each log
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            yearChanges[birth - 1950]++;   // Person is born
            yearChanges[death - 1950]--;   // Person is no longer alive in death year
        }

        int maxPopulation = 0;
        int maxYear = 1950;
        int currentPopulation = 0;

        // Iterate over each year from 1950 to 2050
        for (int i = 0; i < yearChanges.length; i++) {
            currentPopulation += yearChanges[i];

            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                maxYear = 1950 + i;
            }
        }

        return maxYear;
    }

    public static void main(String[] args) {
        int[][] logs1 = {{1993, 1999}, {2000, 2010}};
        int[][] logs2 = {{1950, 1961}, {1960, 1971}, {1970, 1981}};

        System.out.println("Earliest max population year: " + maximumPopulation(logs1)); // Output: 1993
        System.out.println("Earliest max population year: " + maximumPopulation(logs2)); // Output: 1960
    }
}
