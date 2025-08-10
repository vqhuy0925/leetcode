import java.util.Arrays;

public class ReorderedPowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("n = 16: " + solution.reorderedPowerOf2(16));
        System.out.println("n = 10: " + solution.reorderedPowerOf2(10));
        System.out.println("n = 46: " + solution.reorderedPowerOf2(46));
    }

    static class Solution {
        public boolean reorderedPowerOf2(int n) {
        int[] nCounts = countDigits(n);

        int powerOfTwo = 1;
        for (int i = 0; i < 30; i++) {

            int[] powerOfTwoCounts = countDigits(powerOfTwo);

            if (Arrays.equals(nCounts, powerOfTwoCounts)) {
                return true;
            }

            powerOfTwo *= 2;
        }

        return false;
    }


    private int[] countDigits(int num) {
        int[] counts = new int[10];
        String s = String.valueOf(num); 

        for (char c : s.toCharArray()) {
            counts[c - '0']++;
        }
        return counts;
    }
    }
}
