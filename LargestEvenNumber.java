/**
 * ------------------------------------------------------------
 * Class Name : LargestEvenNumber
 *
 * Description :
 * Forms the largest possible even number by deleting characters
 * from the given string containing only '1' and '2'.
 *
 * ------------------------------------------------------------
 */
public class LargestEvenNumber {

    /**
     * Returns the largest possible even-number string.
     */
    public String largestEven(String s) {
        // Find the last occurrence of '2' (only even digit)
        int lastTwoIndex = s.lastIndexOf('2');

        // If no '2' exists, even number cannot be formed
        if (lastTwoIndex == -1) {
            return "";
        }

        // Keep everything up to the last '2'
        return s.substring(0, lastTwoIndex + 1);
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        LargestEvenNumber solution = new LargestEvenNumber();

        System.out.println("Example 1 Output: " + solution.largestEven("1112")); // 1112
        System.out.println("Example 2 Output: " + solution.largestEven("221"));  // 22
        System.out.println("Example 3 Output: " + solution.largestEven("1"));    // ""
    }
}
