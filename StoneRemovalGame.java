/**
 * Problem: Stone Removal Game
 * Difficulty: Easy
 *
 * Alice and Bob take turns removing stones.
 * Alice starts by removing 10 stones, and each subsequent move removes 1 fewer stone.
 * The player unable to move loses.
 * Return true if Alice wins, else false.
 */
public class StoneRemovalGame {
    public boolean canAliceWin(int n) {
        int stonesToRemove = 10;
        boolean isAliceTurn = true;

        // Continue the game while enough stones remain
        while (n >= stonesToRemove) {
            n -= stonesToRemove;        // Remove current stones
            stonesToRemove--;           // Next player removes one less
            isAliceTurn = !isAliceTurn; // Switch turn
        }

        // If last move was by Alice, she wins
        return !isAliceTurn;
    }

    // --- test ---
    public static void main(String[] args) {
        StoneRemovalGame game = new StoneRemovalGame();
        System.out.println(game.canAliceWin(12)); // true
        System.out.println(game.canAliceWin(1));  // false
        System.out.println(game.canAliceWin(20)); // true
        System.out.println(game.canAliceWin(5));  // false
    }
}
