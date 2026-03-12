/**
 * ------------------------------------------------------------
 * Problem : Largest Even Number
 * Class   : LargestEvenNumberBuilder
 * ------------------------------------------------------------
 */

public class LargestEvenNumberBuilder {

    public String largestEven(String s) {

        int lastTwoIndex = -1;

        // Find last occurrence of '2'
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '2') {
                lastTwoIndex = i;
            }
        }

        // If no '2' found → no even number possible
        if (lastTwoIndex == -1) {
            return "";
        }

        // Return substring until last '2'
        return s.substring(0, lastTwoIndex + 1);
    }

    public static void main(String[] args) {

        LargestEvenNumberBuilder obj = new LargestEvenNumberBuilder();

        // Example 1
        String s1 = "1112";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + obj.largestEven(s1));
        // Expected: 1112

        // Example 2
        String s2 = "221";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + obj.largestEven(s2));
        // Expected: 22

        // Example 3
        String s3 = "1";
        System.out.println("\nInput: " + s3);
        System.out.println("Output: " + obj.largestEven(s3));
        // Expected: ""
    }
}