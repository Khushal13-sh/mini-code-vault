/**
 * Problem: Day of the Week
 * Difficulty: Easy
 *
 * Description:
 * Given a date, return the corresponding day of the week for that date.
 * Input is given as three integers: day, month, year.
 *
 * The result must be one of:
 * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 *
 * Example 1:
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 *
 * Example 2:
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 *
 * Example 3:
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 *
 * Constraints:
 * - The given dates are valid
 * - Years are between 1971 and 2100
 *
 * Approach:
 * This solution uses **Zeller’s Congruence** formula to calculate the day of the week:
 *   h = (q + (13(m + 1))/5 + k + (k/4) + (j/4) + 5j) % 7
 *   where:
 *     h → day of week (0 = Saturday, 1 = Sunday, ..., 6 = Friday)
 *     q → day of month
 *     m → month (3 = March, …, 14 = February)
 *     k → year % 100 (year of century)
 *     j → year / 100 (zero-based century)
 *
 * Time Complexity: O(1) (direct formula)
 * Space Complexity: O(1)
 */

public class DayOfTheWeek {

    /**
     * Returns the day of the week for a given date.
     */
    public String dayOfTheWeek(int day, int month, int year) {
        // Adjust month and year for Zeller's formula
        if (month == 1) {
            month = 13;
            year--;
        } else if (month == 2) {
            month = 14;
            year--;
        }

        int q = day;
        int m = month;
        int k = year % 100; // year of century
        int j = year / 100; // zero-based century

        int h = (q + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;

        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return days[h];
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        DayOfTheWeek solution = new DayOfTheWeek();

        System.out.println("Input: 31-8-2019 → Output: " + solution.dayOfTheWeek(31, 8, 2019)); // Saturday
        System.out.println("Input: 18-7-1999 → Output: " + solution.dayOfTheWeek(18, 7, 1999)); // Sunday
        System.out.println("Input: 15-8-1993 → Output: " + solution.dayOfTheWeek(15, 8, 1993)); // Sunday
    }
}
