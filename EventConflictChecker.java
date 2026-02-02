/**
 * ------------------------------------------------------------
 * Class Name : EventConflictChecker
 *
 * Description :
 * Determines whether two time events overlap on the same day.
 *
 * ------------------------------------------------------------
 */
public class EventConflictChecker {

    /**
     * Returns true if the two events have any time conflict.
     */
    public boolean haveConflict(String[] event1, String[] event2) {

        String start1 = event1[0];
        String end1 = event1[1];
        String start2 = event2[0];
        String end2 = event2[1];

        // If one event ends before the other starts, no conflict
        if (end1.compareTo(start2) < 0 || end2.compareTo(start1) < 0) {
            return false;
        }

        return true;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        EventConflictChecker solution = new EventConflictChecker();

        System.out.println(
                solution.haveConflict(
                        new String[]{"01:15", "02:00"},
                        new String[]{"02:00", "03:00"}
                )
        ); // true

        System.out.println(
                solution.haveConflict(
                        new String[]{"01:00", "02:00"},
                        new String[]{"01:20", "03:00"}
                )
        ); // true

        System.out.println(
                solution.haveConflict(
                        new String[]{"10:00", "11:00"},
                        new String[]{"14:00", "15:00"}
                )
        ); // false
    }
}
