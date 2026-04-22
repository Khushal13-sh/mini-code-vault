/*
 add solution for minimum training hours to win competition using greedy simulation
*/

/**
 * Problem: Minimum Hours of Training to Win a Competition
 * Difficulty: Easy
 *
 * Description:
 * You must defeat all opponents with strictly greater energy and experience.
 * You can train to increase energy or experience before starting.
 *
 * Approach:
 * 1. Energy:
 *    - Total energy required = sum of all opponent energy
 *    - You need strictly greater → totalEnergy + 1
 *
 * 2. Experience:
 *    - Simulate each opponent
 *    - If current experience ≤ opponent → train required hours
 *    - Update experience after each fight
 *
 * Why this works:
 * - Energy can be calculated once globally
 * - Experience must be handled step-by-step (greedy simulation)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinimumTrainingHours {

    public int minNumberOfHours(int initialEnergy, int initialExperience,
                                int[] energy, int[] experience) {

        int hours = 0;

        // Step 1: Energy calculation
        int totalEnergyNeeded = 0;
        for (int e : energy) {
            totalEnergyNeeded += e;
        }

        if (initialEnergy <= totalEnergyNeeded) {
            hours += (totalEnergyNeeded - initialEnergy + 1);
        }

        // Step 2: Experience simulation
        int currExp = initialExperience;

        for (int exp : experience) {
            if (currExp <= exp) {
                int need = exp - currExp + 1;
                hours += need;
                currExp += need;
            }
            currExp += exp;
        }

        return hours;
    }

    public static void main(String[] args) {
        MinimumTrainingHours obj = new MinimumTrainingHours();

        // Example 1
        int initialEnergy1 = 5, initialExperience1 = 3;
        int[] energy1 = {1, 4, 3, 2};
        int[] experience1 = {2, 6, 3, 1};
        System.out.println("Output 1: " +
                obj.minNumberOfHours(initialEnergy1, initialExperience1, energy1, experience1)); // 8

        // Example 2
        int initialEnergy2 = 2, initialExperience2 = 4;
        int[] energy2 = {1};
        int[] experience2 = {3};
        System.out.println("Output 2: " +
                obj.minNumberOfHours(initialEnergy2, initialExperience2, energy2, experience2)); // 0
    }
}