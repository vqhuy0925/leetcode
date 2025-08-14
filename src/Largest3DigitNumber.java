public class Largest3DigitNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("num = 123: " + solution.largestGoodInteger("123"));
        System.out.println("num = 222994447666: " + solution.largestGoodInteger("222444666"));
    }

    static class Solution {
        public String largestGoodInteger(String num) {
            char maxDigit = '/';
            for (int i = 0; i <= num.length() - 3; i++) {
                if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                    if (num.charAt(i) >= maxDigit) {
                        maxDigit = num.charAt(i);
                    }
                }
            }
            if (maxDigit == '/') {
                return "";
            }
            return String.valueOf(maxDigit) + String.valueOf(maxDigit) + String.valueOf(maxDigit);
        }
    }
}
