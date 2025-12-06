/**
 * Problem: Find the Winning Player in Coin Game
 * Difficulty: Easy
 *
 * Alice and Bob take turns picking coins totaling exactly 115.
 * Each valid move requires: 1 coin of value 75 and 4 coins of value 10.
 * Players alternate turns starting with Alice.
 * The player unable to make a move loses.
 */

class Solution {

    public String winningPlayer(int x, int y) {
        // One turn requires 1 coin worth 75 and 4 coins worth 10
        int totalMoves = Math.min(x, y / 4);

        // If total moves are odd → Alice wins (because she starts)
        return (totalMoves % 2 == 1) ? "Alice" : "Bob";
    }

    // Main method to test with examples
    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.winningPlayer(2, 7));   // Output: Alice
        System.out.println(obj.winningPlayer(4, 11));  // Output: Bob
        System.out.println(obj.winningPlayer(5, 20));  // Output: Alice
    }
}
