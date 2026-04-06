/*
 add solution for kth largest element in a stream using min heap approach
*/

/**
 * Problem: Kth Largest Element in a Stream
 * Difficulty: Easy
 *
 * Description:
 * Design a class that continuously maintains the kth largest element
 * in a stream of integers.
 *
 * Approach:
 * - Use a Min Heap (PriorityQueue)
 * - Keep only k largest elements in the heap
 * - The top of the heap (peek) will always be the kth largest element
 *
 * Steps:
 * - Add element to heap
 * - If heap size exceeds k → remove smallest element
 * - Return heap.peek()
 *
 * Why this works:
 * Heap always stores top k largest elements, and the smallest among them
 * represents the kth largest overall.
 *
 * Time Complexity:
 * - add(): O(log k)
 * Space Complexity: O(k)
 */
import java.util.*;

public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        // Example 1
        KthLargest obj1 = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(obj1.add(3));   // 4
        System.out.println(obj1.add(5));   // 5
        System.out.println(obj1.add(10));  // 5
        System.out.println(obj1.add(9));   // 8
        System.out.println(obj1.add(4));   // 8

        // Example 2
        KthLargest obj2 = new KthLargest(4, new int[]{7, 7, 7, 7, 8, 3});
        System.out.println(obj2.add(2));   // 7
        System.out.println(obj2.add(10));  // 7
        System.out.println(obj2.add(9));   // 7
        System.out.println(obj2.add(9));   // 8
    }
}