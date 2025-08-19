public class NumberOfZeroFilledSubArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.zeroFilledSubarray(new int[] { 1, 0, 0, 0, 4 }));
        System.out.println(solution.zeroFilledSubarray(new int[] { 0, 0, 0, 2, 0, 0 }));
    }

    static class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long ans = 0, cur = 0;
            for (int x : nums) {
                if (x == 0) {
                    cur++;
                    ans += cur;
                } else {
                    cur = 0;
                }
            }
            return ans;
        }

        public long zeroFilledSubarray2(int[] nums) {
            long count = 0;
            long totalSubArrays = 0;
            for (int num : nums) {
                if (num == 0) {
                    count++;
                } else {
                    totalSubArrays += (count * (count + 1)) / 2;
                    count = 0;
                }
            }
            totalSubArrays += (count * (count + 1)) / 2;
            return totalSubArrays;
        }
    }
}
