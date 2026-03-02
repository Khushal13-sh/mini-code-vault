/**
 * ------------------------------------------------------------
 * Problem : The Employee That Worked on the Longest Task
 * Class   : LongestTaskEmployeeFinder
 * ------------------------------------------------------------
 */
class LongestTaskEmployeeFinder {

    public int hardestWorker(int n, int[][] logs) {

        int maxDuration = logs[0][1]; // first task duration
        int resultId = logs[0][0];

        int prevTime = logs[0][1];

        for (int i = 1; i < logs.length; i++) {

            int id = logs[i][0];
            int duration = logs[i][1] - prevTime;

            // Check longest duration or smaller id in tie
            if (duration > maxDuration ||
               (duration == maxDuration && id < resultId)) {

                maxDuration = duration;
                resultId = id;
            }

            prevTime = logs[i][1];
        }

        return resultId;
    }
}