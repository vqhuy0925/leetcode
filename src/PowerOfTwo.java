public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("n = 16: " + solution.isPowerOfTwo(16));
        System.out.println("n = 10: " + solution.isPowerOfTwo(10));
    }

    static class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
