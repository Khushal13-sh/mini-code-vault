/*
 add solution for finding elapsed seconds between two times
*/

/**
 * Problem: Number of Elapsed Seconds Between Two Times
 * Difficulty: Easy
 *
 * Description:
 * Given two valid times in the format "HH:MM:SS",
 * return the number of seconds elapsed from
 * startTime to endTime.
 *
 * Key Insight:
 * - Convert both times into total seconds.
 * - The elapsed time is simply the difference
 *   between the two values.
 *
 * Approach:
 * - Parse hours, minutes, and seconds.
 * - Convert each time to total seconds.
 * - Return endTimeSeconds - startTimeSeconds.
 *
 * Why this works:
 * Converting both times to a common unit
 * (seconds) makes it easy to calculate
 * the elapsed duration.
 *
 * Time Complexity: O(1)
 *
 * Space Complexity: O(1)
 * Only a few variables are used.
 */
public class NumberOfElapsedSecondsBetweenTwoTimes {

    public int secondsBetweenTimes(String startTime, String endTime) {
        return toSeconds(endTime) - toSeconds(startTime);
    }

    private int toSeconds(String time) {

        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        int seconds = Integer.parseInt(time.substring(6, 8));

        return hours * 3600 + minutes * 60 + seconds;
    }

    public static void main(String[] args) {

        NumberOfElapsedSecondsBetweenTwoTimes obj =
                new NumberOfElapsedSecondsBetweenTwoTimes();

        // Example 1
        String startTime1 = "01:00:00";
        String endTime1 = "01:00:25";

        System.out.println("Output 1: " +
                obj.secondsBetweenTimes(startTime1, endTime1));

        // Example 2
        String startTime2 = "12:34:56";
        String endTime2 = "13:00:00";

        System.out.println("Output 2: " +
                obj.secondsBetweenTimes(startTime2, endTime2));
    }
}