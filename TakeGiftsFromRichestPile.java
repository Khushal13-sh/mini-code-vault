import java.util.Collections;
import java.util.PriorityQueue;

/**
 * ------------------------------------------------------------
 * Class Name : TakeGiftsFromRichestPile
 *
 * Description :
 * Repeatedly selects the pile with the maximum gifts,
 * replaces it with the floor of its square root,
 * and returns the total gifts remaining after k seconds.
 *
 * ------------------------------------------------------------
 */
public class TakeGiftsFromRichestPile {

    /**
     * Returns total remaining gifts after k operations.
     */
    public long pickGifts(int[] gifts, int k) {

        // Max heap to always get the largest pile
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all piles to heap
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        // Perform k operations
        while (k-- > 0) {
            int max = maxHeap.poll();
            int remaining = (int) Math.floor(Math.sqrt(max));
            maxHeap.offer(remaining);
        }

        // Calculate total remaining gifts
        long total = 0;
        for (int gift : maxHeap) {
            total += gift;
        }

        return total;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        TakeGiftsFromRichestPile solution = new TakeGiftsFromRichestPile();

        System.out.println(solution.pickGifts(
                new int[]{25,64,9,4,100}, 4
        )); // 29

        System.out.println(solution.pickGifts(
                new int[]{1,1,1,1}, 4
        )); // 4
    }
}