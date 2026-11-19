import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem: Course Schedule
 *
 * Description:
 * Given the total number of courses and a list of prerequisites,
 * determine whether it is possible to complete all courses.
 *
 * A prerequisite [a, b] means course b must be completed
 * before course a.
 *
 * If the dependency graph contains a cycle, all courses
 * cannot be completed.
 *
 * Approach: BFS - Kahn's Algorithm (Topological Sorting)
 *
 * 1. Build an adjacency list to represent course dependencies.
 * 2. Calculate the indegree of every course.
 *    Indegree represents the number of prerequisites required
 *    before a course can be taken.
 * 3. Add all courses with indegree 0 to the queue.
 * 4. Process courses using BFS:
 *    - Remove a course from the queue.
 *    - Mark it as completed.
 *    - Decrease the indegree of its dependent courses.
 *    - Add courses whose indegree becomes 0 to the queue.
 * 5. If completed courses equal numCourses, return true.
 *    Otherwise, a cycle exists, so return false.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build the graph and calculate indegree.
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            adj.get(preCourse).add(course);

            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add courses that have no prerequisites.
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;

        // Process courses using BFS.
        while (!queue.isEmpty()) {

            int currentCourse = queue.poll();

            completedCourses++;

            for (int nextCourse : adj.get(currentCourse)) {

                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return completedCourses == numCourses;
    }

    public static void main(String[] args) {

        CourseSchedule solution = new CourseSchedule();

        int[][] prerequisites1 = {
            {1, 0}
        };

        int[][] prerequisites2 = {
            {1, 0},
            {0, 1}
        };

        System.out.println(solution.canFinish(2, prerequisites1));
        System.out.println(solution.canFinish(2, prerequisites2));
    }
}