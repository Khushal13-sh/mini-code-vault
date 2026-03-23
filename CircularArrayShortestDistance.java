class CircularArrayShortestDistance {

    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (words[i].equals(target)) {

                // Distance moving right (forward)
                int right = (i - startIndex + n) % n;

                // Distance moving left (backward)
                int left = (startIndex - i + n) % n;

                int distance = Math.min(left, right);

                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularArrayShortestDistance obj = new CircularArrayShortestDistance();

        String[] words1 = {"hello","i","am","leetcode","hello"};
        System.out.println(obj.closestTarget(words1, "hello", 1)); // Output: 1

        String[] words2 = {"a","b","leetcode"};
        System.out.println(obj.closestTarget(words2, "leetcode", 0)); // Output: 1

        String[] words3 = {"i","eat","leetcode"};
        System.out.println(obj.closestTarget(words3, "ate", 0)); // Output: -1
    }
}