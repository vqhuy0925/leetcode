import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasketsII {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] fruits1 = { 10, 20, 30 };
        int[] baskets = { 15, 5, 25 };
        System.out.println("Unplaced Count: "+ sol.countUnplacedFruits(fruits1, baskets));
        // Expect: output = 1;
    }

    private static class Solution {
        public int countUnplacedFruits(int[] fruits, int[] baskets) {
            int unplacedCount = 0;
            int n = baskets.length;
            boolean[] basketUsed = new boolean[n];
            for (int fruitQty : fruits) {
                boolean wasPlaced = false;
                for (int j = 0; j < n; j++) {
                    if (!basketUsed[j] && baskets[j] >= fruitQty) {
                        basketUsed[j] = true;
                        wasPlaced = true;
                        break;
                    }
                }
                if (!wasPlaced) {
                    unplacedCount++;
                }
            }
            return unplacedCount;
        }
    }
}
