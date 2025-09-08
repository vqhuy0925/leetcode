public class NoZeroNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.getNoZeroIntegers(2);
        for (int i : result) {
             System.out.println(i);
        }
    }

    static class Solution {
        private boolean isNoZero(int x) {
            while (x > 0) {
                if (x % 10 == 0) {
                    return false;
                }
                x = x / 10;
            }
            return true;
        }

        public int[] getNoZeroIntegers(int n) {
            for (int a = 1; a <= n - 1; a++) {
                int b = n - a;
                if (isNoZero(a) && isNoZero(b)) {
                    return new int[] { a, b };
                }
            }
            return new int[] { -1, -1 };
        }
    }
}
