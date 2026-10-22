
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Course Schedule II
 * Difficulty: Medium
 *
 * Approach:
 * Use Kahn's Algorithm (BFS-based Topological Sorting).
 *
 * A course can be taken only after all its prerequisites
 * have been completed.
 *
 * If a cycle exists in the prerequisite graph, it is
 * impossible to complete all courses.
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list:
        // adj.get(course) contains the courses that depend
        // directly on the current course.
        List<List<Integer>> adj = new ArrayList<>();

        // indegree[i] represents the number of prerequisites
        // that course i still needs to complete.
        int[] indegree = new int[numCourses];

        // Initialize an empty adjacency list for each course.
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the directed graph from the prerequisites.
        for (int[] prerequisite : prerequisites) {

            // Course a can be taken only after course b.
            int a = prerequisite[0];
            int b = prerequisite[1];

            // Add a directed edge from b to a.
            adj.get(b).add(a);

            // Course a has one additional prerequisite.
            indegree[a]++;
        }

        // The queue stores courses whose prerequisites
        // have all been completed.
        Queue<Integer> queue = new LinkedList<>();

        // Initially, add all courses with no prerequisites.
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Store the valid course completion order.
        int[] order = new int[numCourses];

        // Points to the next available position in the result.
        int index = 0;

        // Process courses using BFS.
        while (!queue.isEmpty()) {

            // Take a course whose prerequisites are satisfied.
            int course = queue.poll();

            // Add the completed course to the result.
            order[index] = course;
            index++;

            // Process every course that depends on this course.
            for (int next : adj.get(course)) {

                // One prerequisite of the dependent course
                // has now been completed.
                indegree[next]--;

                // If no prerequisites remain, this course
                // is now ready to be completed.
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If every course was processed, a valid ordering exists.
        // Otherwise, a cycle prevents completion of all courses.
        if (index == numCourses) {
            return order;
        }

        // Return an empty array when a cycle exists.
        return new int[0];
    }

    // Helper method to print an array.
    private static void printOrder(int[] order) {
        System.out.print("Output: [");

        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i]);

            if (i < order.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    // Main method for testing.
    public static void main(String[] args) {

        CourseScheduleII solution = new CourseScheduleII();

        // Test Case 1: One prerequisite.
        int numCourses1 = 2;
        int[][] prerequisites1 = {
            {1, 0}
        };

        System.out.println("Test Case 1:");
        printOrder(solution.findOrder(numCourses1, prerequisites1));
        // Expected: [0, 1]

        // Test Case 2: Multiple dependencies.
        int numCourses2 = 4;
        int[][] prerequisites2 = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        System.out.println("\nTest Case 2:");
        printOrder(solution.findOrder(numCourses2, prerequisites2));
        // Expected: [0, 1, 2, 3] or [0, 2, 1, 3]

        // Test Case 3: Only one course.
        int numCourses3 = 1;
        int[][] prerequisites3 = {};

        System.out.println("\nTest Case 3:");
        printOrder(solution.findOrder(numCourses3, prerequisites3));
        // Expected: [0]

        // Test Case 4: Cycle exists.
        int numCourses4 = 2;
        int[][] prerequisites4 = {
            {1, 0},
            {0, 1}
        };

        System.out.println("\nTest Case 4:");
        printOrder(solution.findOrder(numCourses4, prerequisites4));
        // Expected: []

        // Test Case 5: No prerequisites.
        int numCourses5 = 3;
        int[][] prerequisites5 = {};

        System.out.println("\nTest Case 5:");
        printOrder(solution.findOrder(numCourses5, prerequisites5));
        // Expected: [0, 1, 2]
    }
}
