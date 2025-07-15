/**
 * Problem: Number of Students Unable to Eat Lunch
 * Difficulty: Easy
 *
 * Students queue up with their sandwich preference.
 * A student either takes the top sandwich if it matches their preference,
 * or goes to the end of the queue. The process stops when no student 
 * wants the top sandwich.
 *
 * Goal: Return the number of students unable to eat.
 */

public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int zeroPref = 0;
        int onePref = 0;

        for (int stu : students) {
            if (stu == 0) zeroPref++;
            else onePref++;
        }

        for (int sand : sandwiches) {
            if (sand == 0) {
                if (zeroPref == 0) return onePref;
                zeroPref--;
            } else {
                if (onePref == 0) return zeroPref;
                onePref--;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch solution = new NumberOfStudentsUnableToEatLunch();

        System.out.println(solution.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1})); // Output: 0
        System.out.println(solution.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1})); // Output: 3
        System.out.println(solution.countStudents(new int[]{0, 0, 0}, new int[]{1, 1, 1})); // Output: 3
    }
}
