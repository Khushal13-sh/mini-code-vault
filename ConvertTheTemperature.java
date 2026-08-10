/*
 add solution for converting temperature from Celsius to Kelvin and Fahrenheit
*/

/**
 * Problem: Convert the Temperature
 * Difficulty: Easy
 *
 * Description:
 * Given a temperature in Celsius, convert it into:
 * - Kelvin
 * - Fahrenheit
 *
 * Return both values in an array:
 * [Kelvin, Fahrenheit]
 *
 * Key Insight:
 * Use the given temperature conversion formulas:
 * - Kelvin = Celsius + 273.15
 * - Fahrenheit = Celsius * 1.80 + 32.00
 *
 * Approach:
 * - Calculate the Kelvin temperature.
 * - Calculate the Fahrenheit temperature.
 * - Return both values in a double array.
 *
 * Why this works:
 * The problem directly provides the formulas needed
 * to convert Celsius into Kelvin and Fahrenheit.
 *
 * Time Complexity: O(1)
 *
 * Space Complexity: O(1)
 * The returned array contains exactly two values.
 */
public class ConvertTheTemperature {

    public double[] convertTemperature(double celsius) {

        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;

        return new double[]{kelvin, fahrenheit};
    }

    public static void main(String[] args) {

        ConvertTheTemperature obj =
                new ConvertTheTemperature();

        // Example 1
        double[] result1 = obj.convertTemperature(36.50);

        System.out.println("Output 1:");
        System.out.println("Kelvin: " + result1[0]);
        System.out.println("Fahrenheit: " + result1[1]);

        // Example 2
        double[] result2 = obj.convertTemperature(122.11);

        System.out.println("\nOutput 2:");
        System.out.println("Kelvin: " + result2[0]);
        System.out.println("Fahrenheit: " + result2[1]);
    }
}