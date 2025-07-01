import java.util.Arrays;

/**
 * Problem: Minimum Number of Moves to Seat Everyone
 * Difficulty: Easy
 *
 * Sort both arrays and pair each student to the closest seat by index.
 * Then, sum up the absolute differences between positions.
 */

public class MinMovesToSeat {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }

    public static void main(String[] args) {
        MinMovesToSeat solution = new MinMovesToSeat();

        int[] seats1 = {3, 1, 5}, students1 = {2, 7, 4};
        int[] seats2 = {4, 1, 5, 9}, students2 = {1, 3, 2, 6};
        int[] seats3 = {2, 2, 6, 6}, students3 = {1, 3, 2, 6};

        System.out.println(solution.minMovesToSeat(seats1, students1)); // Output: 4
        System.out.println(solution.minMovesToSeat(seats2, students2)); // Output: 7
        System.out.println(solution.minMovesToSeat(seats3, students3)); // Output: 4
    }
}
