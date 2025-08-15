public class PowerOfFour {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(16));
    }

    static class Solution {
        public boolean isPowerOfFour(int n) {
            if (n <= 0) {
                return false;
            }
            while (n > 1) {
                if (n % 4 != 0) {
                    return false;
                }
                n = n / 4;
            }
            return true;
        }
    }
}
