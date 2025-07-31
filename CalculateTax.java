import java.util.*;

/**
 * Problem: Calculate Amount Paid in Taxes
 * Difficulty: Easy
 *
 * Given income and tax brackets, calculate the total tax amount.
 * 
 * Each bracket [upper, percent] means:
 *  - Income up to 'upper' is taxed at 'percent' (for the portion in this bracket)
 *  - Brackets are cumulative and sorted by 'upper'.
 */
public class CalculateTax {

    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        int prevUpper = 0;

        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];

            // If income is already below or equal to the previous upper bound, stop
            if (income <= prevUpper) break;

            // Calculate the taxable amount for this bracket
            int taxable = Math.min(income, upper) - prevUpper;

            // Add the tax for this portion
            tax += taxable * (percent / 100.0);

            // Move to next bracket
            prevUpper = upper;
        }

        return tax;
    }

    public static void main(String[] args) {
        CalculateTax solution = new CalculateTax();

        int[][] brackets1 = {{3, 50}, {7, 10}, {12, 25}};
        System.out.printf("Output: %.5f\n", solution.calculateTax(brackets1, 10)); 
        // Expected: 2.65000

        int[][] brackets2 = {{1, 0}, {4, 25}, {5, 50}};
        System.out.printf("Output: %.5f\n", solution.calculateTax(brackets2, 2)); 
        // Expected: 0.25000

        int[][] brackets3 = {{2, 50}};
        System.out.printf("Output: %.5f\n", solution.calculateTax(brackets3, 0)); 
        // Expected: 0.00000
    }
}
