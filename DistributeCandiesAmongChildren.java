/**
 * ------------------------------------------------------------
 * Class Name : DistributeCandiesAmongChildren
 *
 * Description :
 * Counts the number of ways to distribute n candies among
 * 3 children such that no child gets more than limit candies.
 *
 * ------------------------------------------------------------
 */
public class DistributeCandiesAmongChildren {

    /**
     * Returns the total number of valid distributions.
     */
    public int distributeCandies(int n, int limit) {
        int count = 0;

        for (int a = 0; a <= limit; a++) {
            for (int b = 0; b <= limit; b++) {
                int c = n - (a + b);
                if (c >= 0 && c <= limit) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        DistributeCandiesAmongChildren solution = new DistributeCandiesAmongChildren();

        System.out.println("Example 1 Output: " +
                solution.distributeCandies(5, 2)); // 3

        System.out.println("Example 2 Output: " +
                solution.distributeCandies(3, 3)); // 10
    }
}
