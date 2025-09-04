import java.util.HashSet;
import java.util.Set;

public class MinOperationsMakeElementsArrayDistinct {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations(new int[] { 4, 5, 6, 4, 4 }));
        System.out.println(solution.minimumOperations(new int[] { 1, 2, 3, 4, 2, 3, 3, 5, 7 }));
        System.out.println(solution.minimumOperations(new int[] { 6, 7, 8, 9 }));
        System.out.println(solution.minimumOperations(new int[] { 2, 3 }));
    }

    static class Solution {
        public int minimumOperations(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Set<Integer> seen = new HashSet<>();
            int n = nums.length;

            for (int i = n - 1; i >= 0; i--) {
                int currentNum = nums[i];

                if (seen.contains(currentNum)) {
                    return (i + 1 + 2) / 3;
                }
                seen.add(currentNum);
            }
            return 0;
        }
    }
}
