import java.util.*;

/**
 * Problem: Count Days Spent Together
 * Difficulty: Easy
 *
 * Alice and Bob are traveling to Rome for separate business meetings.
 * You are given 4 strings:
 * - arriveAlice, leaveAlice: Alice's arrival and departure dates.
 * - arriveBob, leaveBob: Bob's arrival and departure dates.
 *
 * Dates are given in "MM-DD" format for a non-leap year.
 * The task is to return the total number of days they are in Rome together.
 *
 * Approach:
 * 1. Convert each date into its "day of the year" integer representation using a helper method.
 * 2. Find the latest of the two arrival dates (max).
 * 3. Find the earliest of the two departure dates (min).
 * 4. If the overlap exists (start <= end), return the number of days between them inclusive.
 *    Otherwise, return 0.
 *
 * Time Complexity: O(1) — constant number of operations.
 * Space Complexity: O(1) — only a few variables used.
 *
 * Example:
 * Input: arriveAlice = "08-15", leaveAlice = "08-18",
 *        arriveBob = "08-16", leaveBob = "08-19"
 * Output: 3
 * Explanation: Overlap is Aug 16 to Aug 18 → 3 days.
 */
public class CountDaysTogether {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArr = calculateDays(arriveAlice);
        int aliceLev = calculateDays(leaveAlice);

        int bobArr = calculateDays(arriveBob);
        int bobLev = calculateDays(leaveBob);

        int start = Math.max(aliceArr, bobArr);
        int end = Math.min(aliceLev, bobLev);

        return start > end ? 0 : (end - start + 1);
    }

    private int calculateDays(String date) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        int totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        return totalDays + day;
    }

    public static void main(String[] args) {
        CountDaysTogether solution = new CountDaysTogether();

        System.out.println(solution.countDaysTogether("08-15", "08-18", "08-16", "08-19")); // Output: 3
        System.out.println(solution.countDaysTogether("10-01", "10-31", "11-01", "12-31")); // Output: 0
        System.out.println(solution.countDaysTogether("01-01", "12-31", "06-01", "06-15")); // Output: 15
        System.out.println(solution.countDaysTogether("02-10", "02-20", "02-15", "02-18")); // Output: 4
    }
}
