public class FruitsCollected {

    //COPY Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[][] fruits1 = {
                { 10, 1, 1 },
                { 1, 10, 1 },
                { 1, 1, 10 }
        };
        System.out.println("Test Case 1 (n=3):");
        System.out.println(" - Results: " + sol.maxCollectedFruits(fruits1));

        // Test Case 2
        int[][] fruits2 = {
                { 10, 20 },
                { 30, 40 }
        };
        System.out.println("Test Case 2 (n=2):");
        System.out.println(" - Result: " + sol.maxCollectedFruits(fruits2));

        // Test Case 3
        int[][] fruits3 = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        System.out.println("Test Case 3 (All Zeros):");
        System.out.println(" - Result: " + sol.maxCollectedFruits(fruits3));
    }

    static class Solution {
        public int maxCollectedFruits(int[][] fruits) {
            int n = fruits.length;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += fruits[i][i];
            }

            java.util.function.Supplier<Integer> dp = () -> {
                int[] prev = new int[n];
                int[] curr = new int[n];
                java.util.Arrays.fill(prev, Integer.MIN_VALUE);
                java.util.Arrays.fill(curr, Integer.MIN_VALUE);
                prev[n - 1] = fruits[0][n - 1];
                for (int i = 1; i < n - 1; ++i) {
                    for (int j = Math.max(n - 1 - i, i + 1); j < n; ++j) {
                        int best = prev[j];
                        if (j - 1 >= 0)
                            best = Math.max(best, prev[j - 1]);
                        if (j + 1 < n)
                            best = Math.max(best, prev[j + 1]);
                        curr[j] = best + fruits[i][j];
                    }
                    int[] temp = prev;
                    prev = curr;
                    curr = temp;
                }
                return prev[n - 1];
            };

            ans += dp.get();

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = fruits[j][i];
                    fruits[j][i] = fruits[i][j];
                    fruits[i][j] = temp;
                }
            }

            ans += dp.get();
            return ans;
        }
    }
}
