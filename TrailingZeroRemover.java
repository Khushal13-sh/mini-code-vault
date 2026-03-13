/**
 * ------------------------------------------------------------
 * Problem : Remove Trailing Zeros From a String
 * Class   : TrailingZeroRemover
 * ------------------------------------------------------------
 */

public class TrailingZeroRemover {

    public String removeTrailingZeros(String num) {

        int i = num.length() - 1;

        // Move backward while zeros appear
        while (i >= 0 && num.charAt(i) == '0') {
            i--;
        }

        return num.substring(0, i + 1);
    }

    public static void main(String[] args) {

        TrailingZeroRemover obj = new TrailingZeroRemover();

        // Example 1
        String num1 = "51230100";
        System.out.println("Input: " + num1);
        System.out.println("Output: " + obj.removeTrailingZeros(num1));
        // Expected Output: 512301

        // Example 2
        String num2 = "123";
        System.out.println("\nInput: " + num2);
        System.out.println("Output: " + obj.removeTrailingZeros(num2));
        // Expected Output: 123
    }
}