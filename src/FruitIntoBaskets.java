import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // int[] fruits1 = { 1, 2, 1 };
        // System.out.println("[1, 2, 1] -> " + sol.totalFruit(fruits1)); // Expect: 3

        int[] fruits2 = { 0, 1, 2, 2 };
        System.out.println("[0, 1, 2, 2] -> " + sol.totalFruit(fruits2)); // Expect: 3 ([1, 2, 2])

        // int[] fruits3 = { 1, 2, 3, 2, 2 };
        // System.out.println("[1, 2, 3, 2, 2] -> " + sol.totalFruit(fruits3)); // Expect: 4 ([2, 3, 2, 2])

        // int[] fruits4 = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        // System.out.println("[3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4] -> " + sol.totalFruit(fruits4)); // Expect: 5 ([1, 2, 1, 1, 2])
    }

    private static class Solution {
        public int totalFruit(int[] fruits) {
            if (fruits == null || fruits.length == 0) {
                return 0;
            }

            int windowStart = 0;
            int maxLength = 0;
            Map<Integer, Integer> fruitFrequencyMap = new HashMap<>();
            for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
                int rightFruit = fruits[windowEnd];
                System.out.println("rightFruit: "+ rightFruit);
                fruitFrequencyMap.put(rightFruit, fruitFrequencyMap.getOrDefault(rightFruit, 0) + 1);

                while (fruitFrequencyMap.size() > 2) {
                    int leftFruit = fruits[windowStart];
                    System.out.println("leftFruit: "+ leftFruit);
                    fruitFrequencyMap.put(leftFruit, fruitFrequencyMap.get(leftFruit) - 1);
                    if (fruitFrequencyMap.get(leftFruit) == 0) {
                        fruitFrequencyMap.remove(leftFruit);
                    }
                    windowStart++;
                }
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            }
            return maxLength;
        }
    }

}
