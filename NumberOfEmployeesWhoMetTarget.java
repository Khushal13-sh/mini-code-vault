/**
 * ------------------------------------------------------------
 * Class Name : NumberOfEmployeesWhoMetTarget
 *
 * Description :
 * Counts how many employees worked at least the
 * required target number of hours.
 *
 * ------------------------------------------------------------
 */
public class NumberOfEmployeesWhoMetTarget {

    /**
     * Returns the number of employees meeting the target.
     */
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;

        // Check each employee's working hours
        for (int h : hours) {
            if (h >= target) {
                count++;
            }
        }

        return count;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        NumberOfEmployeesWhoMetTarget solution = new NumberOfEmployeesWhoMetTarget();

        System.out.println(solution.numberOfEmployeesWhoMetTarget(
                new int[]{0, 1, 2, 3, 4}, 2
        )); // 3

        System.out.println(solution.numberOfEmployeesWhoMetTarget(
                new int[]{5, 1, 4, 2, 2}, 6
        )); // 0
    }
}
