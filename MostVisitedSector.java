import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ------------------------------------------------------------
 * Class Name : MostVisitedSector
 *
 * Description :
 * Finds the sectors that are visited the maximum number of times
 * on a circular track during a marathon.
 *
 * ------------------------------------------------------------
 */
public class MostVisitedSector {

    /**
     * Returns a list of most visited sectors in ascending order.
     */
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result = new ArrayList<>();

        int start = rounds[0];
        int end = rounds[rounds.length - 1];

        // If no wrap-around
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        } 
        // If wrap-around occurs
        else {
            for (int i = start; i <= n; i++) {
                result.add(i);
            }
            for (int i = 1; i <= end; i++) {
                result.add(i);
            }
        }

        Collections.sort(result);
        return result;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        MostVisitedSector solution = new MostVisitedSector();

        System.out.println(solution.mostVisited(4, new int[]{1, 3, 1, 2})); 
        // [1, 2]

        System.out.println(solution.mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
        // [2]

        System.out.println(solution.mostVisited(7, new int[]{1, 3, 5, 7}));
        // [1, 2, 3, 4, 5, 6, 7]
    }
}
