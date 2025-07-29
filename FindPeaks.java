import java.util.*;

/**
 * Problem: Find the Peaks
 * Difficulty: Easy
 *
 * You are given a 0-indexed array `mountain`. A peak is an element that is strictly
 * greater than its neighboring elements. The first and last elements cannot be peaks.
 *
 * Return a list of indices that represent peaks in the array.
 */

public class FindPeaks {

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();

        // Iterate from second to second-last element
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i);
            }
        }

        return peaks;
    }

    public static void main(String[] args) {
        FindPeaks solution = new FindPeaks();

        int[] test1 = {2, 4, 4};
        System.out.println(solution.findPeaks(test1)); // Output: []

        int[] test2 = {1, 4, 3, 8, 5};
        System.out.println(solution.findPeaks(test2)); // Output: [1, 3]

        int[] test3 = {5, 10, 5, 10, 5};
        System.out.println(solution.findPeaks(test3)); // Output: [1, 3]
    }
}
