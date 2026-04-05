/*
 add solution for minimum capacity box to find smallest valid index
*/

/**
 * Problem: Minimum Capacity Box
 * Difficulty: Easy
 *
 * Description:
 * Find the index of the box with the minimum capacity that can store the given item.
 * If multiple boxes satisfy the condition, return the smallest index.
 * If no box can store the item, return -1.
 *
 * Approach:
 * - Traverse the array
 * - Check if capacity[i] >= itemSize
 * - Keep track of minimum valid capacity and its index
 * - Update only when a smaller valid capacity is found
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinimumCapacityBox {

    public int minimumIndex(int[] capacity, int itemSize) {
        int minCapacity = Integer.MAX_VALUE;
        int resultIndex = -1;

        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize && capacity[i] < minCapacity) {
                minCapacity = capacity[i];
                resultIndex = i;
            }
        }

        return resultIndex;
    }

    public static void main(String[] args) {
        MinimumCapacityBox obj = new MinimumCapacityBox();

        // Example 1
        int[] cap1 = {1, 5, 3, 7};
        int item1 = 3;
        System.out.println("Output 1: " + obj.minimumIndex(cap1, item1)); // 2

        // Example 2
        int[] cap2 = {3, 5, 4, 3};
        int item2 = 2;
        System.out.println("Output 2: " + obj.minimumIndex(cap2, item2)); // 0

        // Example 3
        int[] cap3 = {4};
        int item3 = 5;
        System.out.println("Output 3: " + obj.minimumIndex(cap3, item3)); // -1
    }
}