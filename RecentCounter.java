/*
 add solution for number of recent calls using queue sliding window approach
*/

/**
 * Problem: Number of Recent Calls
 * Difficulty: Easy
 *
 * Description:
 * Design a class that counts the number of recent requests within the last 3000 milliseconds.
 *
 * Approach:
 * - Use a Queue to store timestamps
 * - For each ping(t):
 *      → Add current timestamp to queue
 *      → Remove all timestamps < (t - 3000)
 * - Queue size gives the number of valid recent calls
 *
 * Why this works:
 * This is a sliding window problem where the window size is 3000.
 * Queue helps efficiently add/remove elements in O(1).
 *
 * Time Complexity: O(n) overall
 * Space Complexity: O(n)
 */
import java.util.*;

public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);

        // Remove outdated requests
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1));     // 1
        System.out.println(recentCounter.ping(100));   // 2
        System.out.println(recentCounter.ping(3001));  // 3
        System.out.println(recentCounter.ping(3002));  // 3
    }
}