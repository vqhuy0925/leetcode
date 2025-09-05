public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindromeNumber(121));
         System.out.println(solution.isPalindromeNumber(-121));
        System.out.println(solution.isPalindromeNumber(1234));
    }

    static class Solution {
        public boolean isPalindromeNumber(int x) {
            if(x < 0 || x % 10 == 0 && x != 0){
                return false;
            }
            int reverted_number = 0;
            while (x > reverted_number) {
                int last_digit = x % 10;
                reverted_number = reverted_number * 10 + last_digit;
                x /= 10;
            }
            return x == reverted_number || x == reverted_number / 10;
        }
    }

}
