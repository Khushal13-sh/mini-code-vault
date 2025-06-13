/**
 * Problem: Time Needed to Buy Tickets
 * Difficulty: Easy
 *
 * 📘 Description:
 * You are given an array `tickets`, where each value at index i represents how many tickets the person at position i wants to buy.
 * Each person can only buy one ticket at a time and then goes to the back of the line.
 * Return the total time it takes for the person at index k to buy all their tickets.
 *
 * 🧪 Example:
 * Input: tickets = [2, 3, 2], k = 2
 * Output: 6
 */

public class TimeToBuyTickets {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;

        // Continue until the k-th person has bought all tickets
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--; // Buy 1 ticket
                    time++;       // Count the time

                    // If the k-th person finishes buying tickets
                    if (i == k && tickets[k] == 0) {
                        return time;
                    }
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {
        int[] tickets1 = {2, 3, 2};
        int k1 = 2;
        System.out.println("Total time for person at index " + k1 + ": " + timeRequiredToBuy(tickets1, k1)); // Output: 6

        int[] tickets2 = {5, 1, 1, 1};
        int k2 = 0;
        System.out.println("Total time for person at index " + k2 + ": " + timeRequiredToBuy(tickets2, k2)); // Output: 8
    }
}
