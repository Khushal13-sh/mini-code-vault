/**
 * Problem: Student Attendance Record I
 * Difficulty: Easy
 *
 * A student is eligible for an attendance award if:
 * 1. Absences ('A') are fewer than 2
 * 2. No 3 consecutive late ('L') days occur
 */
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int absences = 0;
        int lateStreak = 0;

        for (char c : s.toCharArray()) {

            if (c == 'A') {
                absences++;
                lateStreak = 0;

                if (absences >= 2) {
                    return false;
                }

            } else if (c == 'L') {
                lateStreak++;

                if (lateStreak >= 3) {
                    return false;
                }

            } else { // 'P'
                lateStreak = 0;
            }
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        StudentAttendanceRecordI obj =
                new StudentAttendanceRecordI();

        System.out.println(obj.checkRecord("PPALLP")); // true
        System.out.println(obj.checkRecord("PPALLL")); // false
    }
}
