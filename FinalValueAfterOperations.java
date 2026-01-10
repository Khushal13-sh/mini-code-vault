/**
 * Problem: Final Value of Variable After Performing Operations
 * Difficulty: Easy
 *
 * Increment or decrement variable X based on given operations.
 */
public class FinalValueAfterOperations {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        // Iterate through all operations
        for (String op : operations) {
            if (op.contains("++")) {
                x++; // Increment operation
            } else {
                x--; // Decrement operation
            }
        }

        return x;
    }

    // Main method for testing
    public static void main(String[] args) {
        FinalValueAfterOperations obj = new FinalValueAfterOperations();

        System.out.println(obj.finalValueAfterOperations(
                new String[]{"--X","X++","X++"})); // 1

        System.out.println(obj.finalValueAfterOperations(
                new String[]{"++X","++X","X++"})); // 3

        System.out.println(obj.finalValueAfterOperations(
                new String[]{"X++","++X","--X","X--"})); // 0
    }
}
