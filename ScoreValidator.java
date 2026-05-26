/*
 add solution for score validator using simulation and switch cases
*/

/**
 * Problem: Score Validator
 * Difficulty: Easy
 *
 * Description:
 * Process the events array from left to right and maintain:
 *
 * - score
 * - counter
 *
 * Rules:
 * - Numeric strings add their value to score
 * - "W" increases counter
 * - "WD" and "NB" add 1 to score
 * - Stop processing when counter becomes 10
 *
 * Return:
 * [score, counter]
 *
 * Key Insight:
 * This is a direct simulation problem where each event
 * changes the score or counter based on fixed rules.
 *
 * Approach:
 * - Traverse events array
 * - Use switch-case for handling each event type
 * - Stop processing once counter reaches 10
 *
 * Why this works:
 * We exactly simulate the process described in the problem.
 *
 * Time Complexity: O(n)
 * n = number of events
 *
 * Space Complexity: O(1)
 */
public class ScoreValidator {

    public int[] scoreValidator(String[] events) {

        int score = 0;
        int counter = 0;

        for (String event : events) {

            // Stop processing if counter becomes 10
            if (counter == 10) {
                break;
            }

            switch (event) {

                case "W":
                    counter++;
                    break;

                case "WD":
                case "NB":
                    score += 1;
                    break;

                default:
                    score += Integer.parseInt(event);
            }
        }

        return new int[]{score, counter};
    }

    public static void main(String[] args) {

        ScoreValidator obj = new ScoreValidator();

        // Example 1
        String[] events1 = {"1", "4", "W", "6", "WD"};

        int[] result1 = obj.scoreValidator(events1);

        System.out.println(
                "Output 1: [" +
                result1[0] + ", " +
                result1[1] + "]"
        ); // [12, 1]

        // Example 2
        String[] events2 = {"WD", "NB", "0", "4", "4"};

        int[] result2 = obj.scoreValidator(events2);

        System.out.println(
                "Output 2: [" +
                result2[0] + ", " +
                result2[1] + "]"
        ); // [10, 0]

        // Example 3
        String[] events3 = {
                "W","W","W","W","W",
                "W","W","W","W","W","W"
        };

        int[] result3 = obj.scoreValidator(events3);

        System.out.println(
                "Output 3: [" +
                result3[0] + ", " +
                result3[1] + "]"
        ); // [0, 10]
    }
}