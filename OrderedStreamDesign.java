/*
 add solution for ordered stream using array and pointer to return sequential chunks
*/

/**
 * Problem: Design an Ordered Stream
 * Difficulty: Easy
 *
 * Description:
 * Insert (id, value) pairs in random order and return
 * the largest possible ordered chunk starting from current pointer.
 *
 * Key Insight:
 * - Maintain a pointer (ptr) starting from 1
 * - Store values in array using id as index
 * - After insertion, return all continuous values from ptr
 *
 * Approach:
 * - Initialize array of size n + 1
 * - Insert value at given id
 * - While stream[ptr] is filled:
 *      → add to result
 *      → move ptr forward
 *
 * Why this works:
 * Pointer ensures we always return values in correct order.
 *
 * Time Complexity:
 * O(n) total across all inserts
 *
 * Space Complexity:
 * O(n)
 */
public class OrderedStreamDesign {

    static class OrderedStream {

        private String[] stream;
        private int ptr;
        private int n;

        public OrderedStream(int n) {
            this.n = n;
            stream = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {

            stream[idKey] = value;
            List<String> result = new ArrayList<>();

            while (ptr <= n && stream[ptr] != null) {
                result.add(stream[ptr]);
                ptr++;
            }

            return result;
        }
    }

    public static void main(String[] args) {

        OrderedStream os = new OrderedStream(5);

        System.out.println(os.insert(3, "ccccc")); // []
        System.out.println(os.insert(1, "aaaaa")); // ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb")); // ["bbbbb", "ccccc"]
        System.out.println(os.insert(5, "eeeee")); // []
        System.out.println(os.insert(4, "ddddd")); // ["ddddd", "eeeee"]
    }
}