
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Problem: Simplify Path
 * Difficulty: Medium
 *
 * Approach:
 * Use a stack to maintain the directory names
 * that belong in the final canonical path.
 *
 * Rules:
 * 1. Empty directory names are ignored.
 * 2. "." represents the current directory and is ignored.
 * 3. ".." removes the most recent directory, if possible.
 * 4. All other names are valid directory names.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {

        // The stack stores valid directory names.
        // The most recently added directory stays at the top.
        Deque<String> stack = new ArrayDeque<>();

        // Split the path using '/'.
        // Consecutive slashes may produce empty directory names.
        String[] directories = path.split("/");

        // Process each directory in the original path.
        for (String directory : directories) {

            // Ignore empty strings caused by repeated slashes.
            // Ignore "." because it represents the current directory.
            if (directory.isEmpty() || directory.equals(".")) {
                continue;
            }

            // ".." means move to the parent directory.
            if (directory.equals("..")) {

                // Move up only if a directory exists to remove.
                // We cannot move above the root directory.
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                // A normal directory name must be preserved.
                // Names such as "...", "....", and "home" are valid.
                stack.push(directory);
            }
        }

        // Build the canonical path.
        StringBuilder result = new StringBuilder();

        // Because push() inserts at the front of the deque,
        // descendingIterator() reads directories from bottom to top.
        // This restores their original path order.
        Iterator<String> iterator = stack.descendingIterator();

        while (iterator.hasNext()) {

            // Every directory must start with exactly one slash.
            result.append("/");
            result.append(iterator.next());
        }

        // If the stack is empty, the canonical path is root.
        if (result.length() == 0) {
            return "/";
        }

        // The result has no repeated separators or trailing slash.
        return result.toString();
    }

    // Main method for testing.
    public static void main(String[] args) {

        SimplifyPath solution = new SimplifyPath();

        // Test Case 1: Remove trailing slash.
        String path1 = "/home/";
        System.out.println(solution.simplifyPath(path1));
        // Expected: /home

        // Test Case 2: Remove repeated slashes.
        String path2 = "/home//foo/";
        System.out.println(solution.simplifyPath(path2));
        // Expected: /home/foo

        // Test Case 3: Move to the parent directory.
        String path3 = "/home/user/Documents/../Pictures";
        System.out.println(solution.simplifyPath(path3));
        // Expected: /home/user/Pictures

        // Test Case 4: Cannot move above root.
        String path4 = "/../";
        System.out.println(solution.simplifyPath(path4));
        // Expected: /

        // Test Case 5: Preserve "..." as a directory name.
        String path5 = "/.../a/../b/c/../d/./";
        System.out.println(solution.simplifyPath(path5));
        // Expected: /.../b/d

        // Test Case 6: Multiple parent directory operations.
        String path6 = "/a/b/../../c";
        System.out.println(solution.simplifyPath(path6));
        // Expected: /c

        // Test Case 7: Empty effective path.
        String path7 = "/a/..";
        System.out.println(solution.simplifyPath(path7));
        // Expected: /
    }
}
