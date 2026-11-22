/*
 * Problem: Gas Station
 *
 * Description:
 * Given two arrays, gas and cost, representing the amount of gas
 * available at each station and the gas required to travel to
 * the next station, find the starting station from which the
 * car can complete the entire circular journey.
 *
 * The car starts with an empty tank and has unlimited tank capacity.
 *
 * Return:
 * - The starting station index if the complete journey is possible.
 * -1 if completing the journey is impossible.
 *
 * Approach: Greedy
 *
 * 1. Calculate the difference between gas and cost at each station.
 * 2. Maintain totalGas to calculate the overall available gas.
 * 3. Maintain currentGas to track the gas available from the
 *    current starting station.
 * 4. If currentGas becomes negative, the current starting station
 *    cannot be a valid starting point.
 *    Move the starting index to the next station and reset currentGas.
 * 5. If totalGas is negative, the journey is impossible.
 *    Otherwise, return the calculated starting index.
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int currentGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {

            int difference = gas[i] - cost[i];

            totalGas += difference;

            currentGas += difference;

            // Current starting station cannot complete the journey.
            if (currentGas < 0) {

                startIndex = i + 1;

                currentGas = 0;
            }
        }

        // Total available gas is insufficient.
        if (totalGas < 0) {
            return -1;
        }

        return startIndex;
    }

    public static void main(String[] args) {

        GasStation solution = new GasStation();

        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};

        System.out.println(solution.canCompleteCircuit(gas1, cost1));
        System.out.println(solution.canCompleteCircuit(gas2, cost2));
    }
}